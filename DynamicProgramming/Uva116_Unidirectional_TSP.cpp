#include <cstdio>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    int m, n;
    const int INF = 0x7FFFFFFF;
    while (scanf("%d%d", &m, &n) == 2 && m) {
        vector<vector<int> > matrix(m, vector<int>(n));
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                scanf("%d", &matrix[i][j]);
            }
        }
        
        vector<vector<int>> next(m, vector<int>(n));
        vector<vector<int>> dp(m, vector<int>(n, INF));
        
        int ans = INF;
        int first = 0;
        
        for (int j = n - 1; j >= 0; j --) {
            for (int i = 0; i < m; i ++) {
                if (j == n - 1) { dp[i][j] = matrix[i][j]; }
                else {
                    int rows[3] = {i, i - 1, i + 1};
                    if (i == 0) { rows[1] = m - 1; }
                    if (i == m - 1) { rows[2] = 0; }
                    sort(rows, rows + 3);
                    
                    for (int k = 0; k < 3; k ++) {
                        int v = dp[rows[k]][j + 1] + matrix[i][j];
                        if (v < dp[i][j]) {
                            dp[i][j] = v;
                            next[i][j] = rows[k];
                        }
                    }
                }
                if (j == 0 && dp[i][j] < ans) {
                    ans = dp[i][j];
                    first = i;
                }
            }
        }
        
        printf("%d", first + 1);
        for (int i = next[first][0], j = 1; j < n; i = next[i][j], j ++) {
            printf(" %d", i + 1);
        }
        printf("\n%d\n", ans);
    }
    return 0;
}