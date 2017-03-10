#include<cstdio>
#include<cstring>
#include<iostream>

using namespace std;

const int maxn = 200 + 10;
int n;
char buf[maxn][maxn];

void dfs(int r, int c) {
    printf("%c(", buf[r][c]);
    if (r + 1 < n && buf[r + 1][c] ==  '|') {
        int i = c;
        while (i - 1 >= 0 && buf[r + 2][i - 1] == '-') { i --; }
        while (buf[r + 2][i] == '-' && buf[r + 3][i] != '\0') {
            if (!isspace(buf[r + 3][i]) && buf[r + 3][i] != '#') {
                 dfs(r + 3, i); 
            }
            i ++;
        }
    }
    printf(")");
}

void solve() {
    n = 0;
    while (true) {
        fgets(buf[n], maxn, stdin);
        if (buf[n][0] == '#') {
            break;
        } else {
            n ++;
        }
    }
    printf("(");
    if (n) {
        for (int i = 0; i < strlen(buf[0]); i ++) {
            if (buf[0][i] != ' ') {
                dfs(0, i);
                break;
            }
        }
    }
    printf(")\n");
}

int main() {
    //freopen("input.txt", "r" , stdin);
    //freopen("output.txt", "w" , stdout);
    int t;
    fgets(buf[0], maxn, stdin);
    sscanf(buf[0], "%d", &t);
    while (t --) {
        solve();
    }
    return 0;
}