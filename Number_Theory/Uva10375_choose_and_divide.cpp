#include <cstdio>
#include <cstring>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

const int MAXN = 10000 + 10;

vector<int> primes;

void make_primes() {
    int vis[MAXN];
    memset(vis, 0, sizeof(vis));
    for (int i = 2; i < MAXN; i++) {
        for (int j = i * 2; j < MAXN; j += i) {
            vis[j] = 1;
        }
    }
    for (int i = 2; i < MAXN; i++) {
        if (!vis[i]) { primes.push_back(i); }
    }
}

vector<int> e(MAXN, 0);

void add_integer(int n, int d) {
    for (int i = 0; i < primes.size(); i++) {
        while (n % primes[i] == 0) {
            e[i] += d;
            n /= primes[i];
        }
        if (n == 1) { break; }
    }
}

void add_factorial(int n, int d) {
    for (int i = 1;i <= n; i++) {
        add_integer(i, d);
    }
}

int main() {
    make_primes();
    int p, q, r, s;
    while (cin >> p >> q >> r >> s) {
        fill(e.begin(), e.end(), 0);
        add_factorial(p, 1);
        add_factorial(q, -1);
        add_factorial(p - q, -1);
        add_factorial(r, -1);
        add_factorial(s, 1);
        add_factorial(r - s, 1);

        double ans = 1;
        for (int i = 0; i < primes.size(); i++) {
            ans *= pow(primes[i], e[i]);
        }
        printf("%.5lf\n", ans);
    }
    return 0;
}