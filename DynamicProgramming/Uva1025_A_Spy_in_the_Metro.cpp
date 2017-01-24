#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;

const int MAXN = 50 + 5;
const int MAXT = 200 + 5;
const int INF = 0x3f3f3f3f;

int main() {
    int n, t;
    int tcase = 1;
    while (scanf("%d", &n) && n) {
        scanf("%d", &t);
        int dp[MAXT][MAXN];
        int has_train[MAXT][MAXN][2];
        int m1, m2;
        int times[MAXN];
        for (int i = 1; i <= n - 1; i ++) {
            scanf("%d", &times[i]);
        }

        memset(has_train, 0, sizeof(has_train));
        scanf("%d", &m1);
        for (int i = 0; i < m1; i ++) {
            int d;
            scanf("%d", &d);
            for (int j = 1; j <= n - 1; j ++) {
                if (d <= t) { has_train[d][j][0] = 1; }
                d += times[j];  
            }
        }

        scanf("%d", &m2);
        for (int i = 0; i < m2; i ++) {
            int d;
            scanf("%d", &d);
            for (int j = n - 1; j >= 1; j --) {
                if (d <= t) { has_train[d][j + 1][1] = 1; }
                d += times[j];
            }
        }

        for (int i = 1; i <= n - 1; i ++) {
            dp[t][i] = INF;
        }
        dp[t][n] = 0;

        for (int i = t - 1; i >= 0; i --) {
            for (int j = 1; j <= n; j ++) {
                dp[i][j] = dp[i + 1][j] + 1;
                if (j < n && has_train[i][j][0] && i + times[j] <= t) {
                    dp[i][j] = min(dp[i][j], dp[i + times[j]][j + 1]);
                }
                if (j > 1 && has_train[i][j][1] && i + times[j - 1] <= t ) {
                    dp[i][j] = min(dp[i][j], dp[i + times[j - 1]][j - 1]);
                }
            } 
        }

        printf("Case Number %d: ", tcase ++);
        if (dp[0][1] >= INF) { printf("impossible\n"); }
        else { printf("%d\n", dp[0][1]); }
    }

    return 0;
} 