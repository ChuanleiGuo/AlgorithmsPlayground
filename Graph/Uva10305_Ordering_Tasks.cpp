#include<cstdio>
#include<cstring>
#include<iostream>

using namespace std;

const int maxn = 100;

int g[maxn + 10][maxn + 10], vis[maxn + 1], stack[maxn + 1];
int pos = 0;
int u, v, m, n;

void push(int x) {
    stack[pos ++] = x;
}

int pop() {
    return stack[-- pos];
}

void dfs(int u) {
    vis[u] = -1;
    for (int i = 1; i <= n; i ++) {
        if (g[u][i] && !vis[i]) {
            dfs(i);
        }
    }
    push(u);
    vis[u] = 1;
}

int main() {
    while (scanf("%d%d", &n, &m) == 2 && (m || n)) {
        while (m --) {
            scanf("%d%d", &u, &v);
            g[u][v] = 1;
        }
        memset(vis, 0, sizeof(vis));
        for (int i = 1; i <= n; i ++) {
            if (!vis[i]) { dfs(i); } 
        }
        while (pos) {
            printf("%d", pop());
            printf("%c", pos > 0 ? ' ' : '\n');
        }
    }
    return 0;
}