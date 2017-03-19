#include<cstdio>
#include<cstring>
#include<cmath>
#include<iostream>

using namespace std;

bool judge(int m, int n) {
    if (m >= 100000) { return false; }
    int c = 0, mask = 0;
    for (int i = 0; i < 5; i ++) {
        c = (int)(m / pow(10, i)) % 10;
        if ((mask >> c) % 2) {
            return false;
        }
        mask |= 1 << c;
    }

    for (int i = 0; i < 5; i ++) {
        c = (int)(n / pow(10, i)) % 10;
        if ((mask >> c) % 2) {
            return false;
        }
        mask |= 1 << c;
    }
    return true;
}

int main() {
    int n;
    int kase = 0;
    while (scanf("%d", &n) && n) {
        int has_ans = false;
        kase ++;
        if (kase > 1) { printf("\n"); }
        for (int i = 1234; i < 100000; i ++) {
            if (judge(n * i, i)) {
                has_ans = true;
                printf("%05d / %05d = %d\n", n * i, i, n);
            }
        }
        if (!has_ans) {
            printf("There are no solutions for %d.\n", n);
        }
    }
    return 0;
}