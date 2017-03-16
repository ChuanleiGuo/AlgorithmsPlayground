#include<cstdio>
#include<cstring>
#include<iostream>
#include<queue>
#include<utility>

using namespace std;

const int maxn = 100000;

struct node {
    int v, c;
    node *next;
} edges[maxn * 4 + 10];

node *adj[maxn + 10];
node *end_edge = edges;

inline void addedge(const int &u, const int &v, const int &c) {
    node *p = ++end_edge;
    p->v = v;
    p->c = c;
    p->next = adj[u];
    adj[u] = p;
}

int d[maxn + 10], path[maxn + 10];
bool vis[maxn + 10];
queue<int> q;

void calculate_distance(int s) {
    memset(d, 0, sizeof(d));
    d[s] = 1;
    q.push(s);
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        for (node *p = adj[u]; p != NULL; p = p->next) {
            int v = p->v;
            if (!d[v]) {
                d[v] = d[u] + 1;
                q.push(v);
            }
        }
    }
}

queue<pair<int, int> > q2;
void shortest_path(int s) {
    memset(path, 0x3f, sizeof(path));
    memset(vis, 0, sizeof(vis));
    q2.push(make_pair(s, 0));
    path[0] = 0;
    while (!q2.empty()) {
        int u = q2.front().first;
        int cy = q2.front().second;
        q2.pop();
        if (path[d[1] - d[u]] != cy || vis[u]) { continue; }
        vis[u] = true;
        for (node *p = adj[u]; p != NULL; p = p->next) {
            int v = p->v;
            int c = p->c;
            if (d[u] != d[v] + 1 || path[d[1] - d[v]] <= c) { continue; }
            path[d[1] - d[v]] = c;
        }
        for (node *p = adj[u]; p != NULL; p = p->next) {
            int v = p->v;
            int c = p->c;
            if (d[u] != d[v] + 1 || path[d[1] - d[v]] != c) { continue; }
            q2.push(make_pair(v, c));
        }
    }
    d[1] -= 1;
    int i;
    printf("%d\n", d[1]);
    for (int i = 1; i <= d[1]; i ++) {
        printf("%d%c", path[i], i == d[1] ? '\n' : ' ');
    }
}

int main() {
    int u, v, c;
    int n, m;
    while (scanf("%d%d", &n, &m) == 2) {
        memset(adj, 0, sizeof(adj));
        end_edge = edges;
        for (int i = 1; i <= m; i ++) {
            scanf("%d%d%d", &u, &v, &c);
            addedge(u, v, c);
            addedge(v, u, c);
        }
        calculate_distance(n);
        shortest_path(1);
    }
    return 0;
}