#include<cstdio>
#include<iostream>

using namespace std;

typedef unsigned long long ull;

int pow_mod(ull a, ull b, int m) {
    int ret = 1;
    while (b) {
        if (b & 1) {
            ret *= a;
            ret %= m;
        }
        a *= a;
        a %= m;
        b >>= 1;
    }
    return ret;
}

void solve() {
    ull a, b;
    int n;
    cin >> a >> b >> n;
    if (n == 1 || !a) { 
        printf("0\n");
        return;
    }
    int m;
    int f[n * n + 10];
    f[1] = 1; f[2] = 1;
    for (int i = 3; i < n * n + 10; i++) {
        f[i] = f[i - 1] + f[i - 2];
        f[i] %= n;
        if (f[i] == f[2] && f[i - 1] == f[1]) {
            m = i - 2;
            break;
        }
    }
    int k = pow_mod(a % m, b, m);
    printf("%d\n", f[k]);
}

int main() {
    int kase = 0;
    scanf("%d", &kase);
    while (kase--) {
        solve();
    }
    return 0;
}