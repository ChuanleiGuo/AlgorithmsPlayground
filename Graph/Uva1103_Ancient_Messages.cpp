#include<iostream>
#include<cstdio>
#include<cctype>
#include<string>
#include<cstring>

using namespace std;

const int MAXN = 200 + 10;
int dir[4][2] = {{1,0},{0,1},{-1,0},{0,-1}};
int m, n;
int graph[MAXN][MAXN];
char alpha[7] = "ADJKSW";
int con[6];
int dic[6][2] = {{1, 0}, {3, 2}, {5, 1}, {4, 4}, {0, 5}, {2, 3}};
int num[16][4] = {{0,0,0,0},{0,0,0,1},{0,0,1,0},{0,0,1,1},
                  {0,1,0,0},{0,1,0,1},{0,1,1,0},{0,1,1,1},
                  {1,0,0,0},{1,0,0,1},{1,0,1,0},{1,0,1,1},
                  {1,1,0,0},{1,1,0,1},{1,1,1,0},{1,1,1,1}};
int cnt;

void dfs_zero(int r, int c) {
    if (r < 0 || r >= n || c < 0 || c >= m || graph[r][c] != 0) {
        return;
    }
    graph[r][c] = -1;
    for (int i = 0; i < 4; i ++) {
        int xx = r + dir[i][0];
        int yy = c + dir[i][1];
        dfs_zero(xx, yy);
    }
}

void dfs(int r, int c) {
    if (r < 0 || r >= n || c < 0 || c >= m || graph[r][c] == -1) {
        return;
    }
    if (graph[r][c] == 0) {
        cnt ++;
        dfs_zero(r, c);
        return;
    }
    graph[r][c] = -1;
    for (int i = 0; i < 4; i ++) {
        int xx = r + dir[i][0];
        int yy = c + dir[i][1];
        dfs(xx, yy);
    }
}

int main() {
    int cas = 0;
    while (cin >> n >> m && n && m) {
        memset(graph, 0, sizeof(graph));
        memset(con, 0, sizeof(con));
        char str[MAXN];
        for (int i = 0; i < n; i ++) {
            cin >> str;
            int len = 0;
            for (int j = 0; j < m; j ++) {
                if (str[j] == '0') {
                    for (int k = 0; k < 4; k ++) {
                        graph[i][len ++] = 0;
                        continue;
                    }
                }
                int tmp;
                if (isalpha(str[j])) {
                    tmp = str[j] - 'a' + 10;
                } else {
                    tmp = str[j] - '0';
                }
                for (int k = 0; k < 4; k ++) {
                    graph[i][len ++] = num[tmp][k];
                }
            }
        }
        m *= 4;
        for (int i = 0; i < n; i ++) {
            if (graph[i][0] == 0) {
                dfs_zero(i, 0);
            }
            if (graph[i][m - 1] == 0) {
                dfs_zero(i, m - 1);
            }
        }

        for (int j = 0; j < m; j ++) {
            if (graph[0][j] == 0) {
                dfs_zero(0, j);
            }
            if (graph[n - 1][j] == 0) {
                dfs_zero(n - 1, j);
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (graph[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    for (int k = 1; k < 6; k ++) {
                        if (cnt == dic[k][0]) {
                            con[dic[k][1]] ++;
                            break;
                        }
                    }
                }
            }
        }

        cout << "Case " << ++ cas << ": ";
        for (int i = 0; i < 6; i ++) {
            for (int j = 0; j < con[i]; j ++) {
                cout << alpha[i];
            }
        }
        cout << endl;
    }
}
