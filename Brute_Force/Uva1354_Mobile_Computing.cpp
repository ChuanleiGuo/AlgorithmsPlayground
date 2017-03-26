#include <cstdio>
#include <cstring>
#include <algorithm>
#include <iostream>

using namespace std;

const int maxn = 15;

bool vis[maxn];
int idx, n, w[maxn];
double ans, r, lw[maxn], rw[maxn];

void build_binary_tree(int dep) {
    if (dep == n) { return; }
    for (int i = 0; i < maxn; i ++) if (vis[i]) {
        for (int j = 0; j < maxn; j ++) if (i != j && vis[j]) {
            double len_left = max(lw[i], lw[j] - 1);
            double len_right = max(rw[i] - 1, rw[j]);

            if (1 + len_left + len_right < r) {
                if (dep == n - 1) { ans = max(1 + len_left + len_right, ans); }
                vis[i] = false;
                vis[j] = false;
                
                vis[idx] = true;
                w[idx] = w[i] + w[j];
                lw[idx] = (w[j] * 1.0 / w[idx]) + len_left;
                rw[idx] = (w[i] * 1.0 / w[idx]) + len_right;

                idx += 1;

                build_binary_tree(dep + 1);

                idx -= 1;
                vis[idx] = false;
                vis[i] = true;
                vis[j] = true;
            }
        }
    }
}

int main() {
    int t;
    scanf("%d", &t);
    while (t --) {
        ans = -1, idx = 0;
        memset(vis, false, sizeof(vis));
        memset(lw, 0.0, sizeof(lw));
        memset(rw, 0.0, sizeof(rw));

        scanf("%lf%d", &r, &n);
        for (int i = 0; i < n; i ++) {
            scanf("%d", &w[i]);
            vis[idx] = true;
            idx += 1;
        }
        if (n == 1) { printf("0.0000000000\n"); continue; }
        build_binary_tree(1);
        printf("%.10lf\n", ans);
    }
    return 0;
}