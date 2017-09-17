#include <cstdio>
#include <iostream>
#include <algorithm>

using namespace std;

const int maxn = 110;
const int INF = 0xfffffff;

struct Node {
    int x, y, w;
} nodes[maxn * maxn];

bool cmp(Node a, Node b) {
    return a.w < b.w;
}

int p[maxn];
int find(int x) {
    if (p[x] != x) { p[x] = find(p[x]); }
    return p[x];
}

int main() {
    while (1) {
        int n, m;
        scanf("%d%d", &n, &m);
        if (n == 0 && m == 0) { break; }
        for (int i = 1; i <= m; i++) {
            scanf("%d%d%d", &nodes[i].x, &nodes[i].y, &nodes[i].w);
        }
        sort(nodes + 1, nodes + 1 + m, cmp);
        int cnt = 0, ans = INF;
        for (int i = 1; i <= m; i++) {
            cnt = 0;
            for (int j = 1; j <= n; j++) {
                p[j] = j;
            }
            for (int j = i; j <= m; j++) {
                int px = find(nodes[j].x), py = find(nodes[j].y);
                if (px != py) {
                    p[px] = py;
                    cnt += 1;
                }
                if (cnt == n - 1) { ans = min(ans, nodes[j].w - nodes[i].w); break; }
            }
        }
        if (ans == INF) { printf("-1\n"); }
        else { printf("%d\n", ans); }
    }
    return 0;
}