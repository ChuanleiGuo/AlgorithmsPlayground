#include <cstdio>
#include <iostream>
#include <cstring>
#include <cmath>
#include <vector>

using namespace std;

vector<bool> isp(33, false);
vector<int> a;
vector<bool> vis;

bool is_prime(int n) {
    if (n < 2) { return false; }
    if (n == 2) { return true; }
    for (int i = 2; i < n; i ++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}

void dfs(int cur, const int &n) {
    if (cur == n && isp[a[0] + a[n - 1]]) {
        for (int i = 0; i < n; i ++) {
            printf("%d", a[i]);
            if (i != n - 1) { printf("%c", ' '); }
        }
        printf("\n");
    } else {
        for (int i = 2; i <= n; i ++) {
            if (!vis[i] && isp[i + a[cur - 1]]) {
                a[cur] = i;
                vis[i] = true;
                dfs(cur + 1, n);
                vis[i] = false;
            }
        }
    }
}

int main() {
    int n;
    for (int i = 2; i <= 32; i ++) {
            isp[i] = is_prime(i);
    }
    int kase = 0;
    while (scanf("%d", &n) != EOF && n) {
        if (kase) { printf("\n"); }
        printf("Case %d:\n", ++kase);
        a = vector<int>(n, 0);
        vis = vector<bool>(n + 1, false);
        a[0] = 1;
        vis[1] = true;
        dfs(1, n);
    }
    return 0;
}