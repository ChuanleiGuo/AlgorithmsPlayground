#include <cstdio>
#include <cstring>
#include <cmath>
#include <iostream>

using namespace std;

const int MAXN = 40000;

int factor[20], nfactor[20], num_factor, flag_factor[100000 + 10];
int count_prime, prime[MAXN + 5], flag[MAXN + 5];

void get_prime() {
    memset(flag, 0, sizeof(flag));
    count_prime = 0;
    for (int i = 2; i <= MAXN; i++) {
        if (flag[i] == 0) {
            flag[i] = 1;
            prime[++count_prime] = i;
            for (int j = 2; j < MAXN / i; j++) {
                flag[i * j] = 1;
            }
        }
    }
}

void get_factor(int m) {
    num_factor = 1;
    memset(nfactor, 0, sizeof(nfactor));
    memset(factor, 0, sizeof(factor));
    for (int i = 1; i <= count_prime; i++) {
        if (m < prime[i]) { break; }
        if (m % prime[i] == 0) {
            factor[num_factor] = prime[i];
            while (m % prime[i] == 0 && m) {
                nfactor[num_factor]++;
                m = m / prime[i];
            }
            num_factor++;
            if (m == 0 || m == 1) { break; }
        }
    }
    if (m > 1) {
        factor[num_factor] = m;
        nfactor[num_factor]++;
        num_factor++;
    }
}

bool check(int x, int y) {
    bool check_flag = true;
    for (int i = 1; i < num_factor; i++) {
        while (x % factor[i] == 0 && x) {
            x = x / factor[i];
            nfactor[i]--;
        }
        while (y % factor[i] == 0 && x) {
            y = y / factor[i];
            nfactor[i]++;
        }
        if (nfactor[i] >= 1) {
            check_flag = false;
        }
    }
    return check_flag;
}

int main() {
    int n, m;
    get_prime();
    while (scanf("%d%d", &n, &m) != EOF) {
        get_factor(m);
        int cnt = 0, ends = 0;
        memset(flag_factor, 0, sizeof(flag_factor));
        for (int i = 1; i <= n; i++) {
            if (check(n - i, i)) {
                flag_factor[i + 1] = 1;
                ends = i + 1;
                cnt++;
            }
        }
        printf("%d\n", cnt);
        if (cnt > 0) {
            for (int i = 1; i < ends; i++) {
                if (flag_factor[i]) {
                    printf("%d ", i);
                }
            }
            printf("%d", ends);
        }
        printf("\n");
    }
    return 0;
}