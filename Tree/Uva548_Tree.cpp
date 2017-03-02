#include<iostream>
#include<cstdio>
#include<sstream>
#include<string>
#include<cstring>

using namespace std;

const int maxn = 1000 + 10;
int in_order[maxn], post_order[maxn], lch[maxn], rch[maxn];
int n;
int best, best_sum;

bool read_list(int *list) {
    string line;
    if (!getline(cin, line)) { return false; }
    stringstream ss(line);
    n = 0;
    int x;
    while (ss >> x) {
        list[n ++] = x;
    }
    return n > 0;
}

int build(int l1, int r1, int l2, int r2) {
    if (l1 > r1) { return 0; }
    int root = post_order[r2];
    int p = l1;
    while (in_order[p] != root) { p ++; }
    int cnt = p - l1;
    lch[root] = build(l1, p - 1, l2, l2 + cnt - 1);
    rch[root] = build(p + 1, r1, l2 + cnt, r2 - 1);
    return root;
}

void dfs(int u, int sum) {
    sum += u;
    if (!lch[u] && !rch[u]) {
        if (sum < best_sum || (sum == best_sum && u < best)) {
            best = u;
            best_sum = sum;
        }
    }
    if (lch[u]) { dfs(lch[u], sum); }
    if (rch[u]) { dfs(rch[u], sum); }
}

int main() {
    memset(lch, 0, sizeof(lch));
    memset(rch, 0, sizeof(rch));
    while(read_list(in_order)) {
        read_list(post_order);
        build(0, n - 1, 0, n -1);
        best_sum = 0x7fffffff;
        dfs(post_order[n - 1], 0);
        cout << best << "\n";
    }
    return 0;
}

