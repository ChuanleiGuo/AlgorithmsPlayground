#include <cstdio>
#include <cassert>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

const int MAXN = 1e3 + 3;
const int MAXM = MAXN * MAXN / 2;
const int MAXQ = 8 + 2;

struct Edge {
    int u, v, w;
    Edge() {}
    Edge(int _u, int _v, int _w): u(_u), v(_v), w(_w) {}
    bool operator < (const Edge &oth) const {
        return w < oth.w;
    }
} es[MAXM];

struct UnionFind {
    int fa[MAXN];
    void init(int n) {
        for (int i = 0; i <= n; i++) {
            fa[i] = i;
        }
    }
    int find(int x) { return x == fa[x] ? x : fa[x] = find(fa[x]); }
    bool unite(int a, int b) {
        int x = find(a), y = find(b);
        if (x == y) { return false; }
        fa[x] = y;
        return true;
    }
} uf;

int n, m, q;
int subnet_size[MAXQ], subnet_cost[MAXQ], subnet[MAXQ][MAXN];
int x[MAXN], y[MAXN];

struct Kruskal {
    vector<Edge> chosen_edge;
    int solve_without_subnet() {
        chosen_edge.clear();
        uf.init(n);
        sort(es, es + m);
        int cost = 0;
        for (int i = 0; i < m; i++) {
            int u = es[i].u, v = es[i].v, w = es[i].w;
            if (uf.unite(u, v)) {
                cost += w;
                chosen_edge.push_back(es[i]);
                if (chosen_edge.size() == n - 1) { break; }
            }
        }
        assert(chosen_edge.size() == n - 1);
        return cost;
    }
    int solve_with_subnets(int s) {
        uf.init(n);
        int cost = 0, picked = 0;
        for (int i = 0; i < q; i++) {
            if (s & (1 << i)) {
                cost += subnet_cost[i];
                for (int j = 0; j < subnet_size[i]; j++) {
                    for (int k = j + 1; k < subnet_size[i]; k++) {
                        if (uf.unite(subnet[i][j], subnet[i][k])) {
                            picked++;
                        }
                    }
                }
            }
        }
        if (picked == n - 1) { return cost; }
        for (Edge &e: chosen_edge) {
            int u = e.u, v = e.v, w = e.w;
            if (uf.unite(u, v)) {
                cost += w;
                if (++picked == n - 1) { break; }
            }
        }
        assert(picked == n - 1);
        return cost;
    }
} mst;

int eu_dist(int a, int b) {
    int dx2 = (x[a] - x[b]) * (x[a] - x[b]);
    int dy2 = (y[a] - y[b]) * (y[a] - y[b]);
    return dx2 + dy2;
}

void get_edge_cost() {
    m = 0;
    for (int i = 1; i < n; i++) {
        for (int j = i + 1; j <=n; j++) {
            es[m++] = Edge(i, j, eu_dist(i, j));
        }
    }
}

void solve() {
    get_edge_cost();
    int ans = mst.solve_without_subnet();
    for (int i = 1; i < (1 << q); i++) {
        ans = min(ans, mst.solve_with_subnets(i));
    }
    printf("%d\n", ans);
}

int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        scanf("%d%d", &n, &q);
        for (int i = 0; i < q; i++) {
            scanf("%d%d", &subnet_size[i], &subnet_cost[i]);
            for (int j = 0; j < subnet_size[i]; j++) {
                scanf("%d", &subnet[i][j]);
            }
        }
        for (int i = 1; i <= n; i++) {
            scanf("%d%d", &x[i], &y[i]);
        }
        solve();
        if (t) { puts(""); }
    }
    return 0;
}
