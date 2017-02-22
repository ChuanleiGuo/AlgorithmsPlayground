#include <iostream>
#include <cstdio>
#include <cmath>
#include <cstring>
#include <algorithm>
#include <cstdlib>
#include <stack>
#include <cctype>
#include <string>
#include <malloc.h>
#include <queue>
#include <map>

using namespace std;
const int INF = 0xffffff;
const double Pi = 4 * atan(1);
const int Maxn = 200 + 10;
int dir2[8][2] = {{-1,0},{0,-1},{-1,1},{1,-1},{-1,-1},{1,0},{0,1},{1,1}};
int dir[4][2] = {{1,0},{0,1},{-1,0},{0,-1}};
int m,n;
int graph[Maxn][Maxn];
char alpha[] = "ADJKSW";
int con[6];
int dic[6][2] = {{1,0},{3,2},{5,1},{4,4},{0,5},{2,3}};
int num[16][4] = {{0,0,0,0},{0,0,0,1},{0,0,1,0},{0,0,1,1},
                  {0,1,0,0},{0,1,0,1},{0,1,1,0},{0,1,1,1},
                  {1,0,0,0},{1,0,0,1},{1,0,1,0},{1,0,1,1},
                  {1,1,0,0},{1,1,0,1},{1,1,1,0},{1,1,1,1}};
int cnt;

void dfsZero(int r,int c){
    if(r < 0 || r >= n || c < 0 || c >= m || graph[r][c] != 0)
        return;
    graph[r][c] = -1;
    for(int i = 0;i < 4;i++){
        int xx = dir[i][0] + r;
        int yy = dir[i][1] + c;
        dfsZero(xx,yy);
    }
}

void dfs(int r,int c){
    if(r < 0 || r >= n || c < 0 || c >= m || graph[r][c] == -1)
        return;
    if(graph[r][c] == 0){
        cnt++;
        dfsZero(r,c);
        return;
    }
    graph[r][c] = -1;
    for(int i = 0;i < 4;i++){
        int xx = dir[i][0] + r;
        int yy = dir[i][1] + c;
        dfs(xx,yy);
    }
}

int main()
{
#ifndef ONLINE_JUDGE
    freopen("inpt.txt","r",stdin);
#endif
    int cas = 0;
    while(cin >> n >> m && n && m){
        memset(graph,0,sizeof(graph));
        memset(con,0,sizeof(con));
        char str[Maxn];
        for(int i = 0;i < n;i++){
            cin >> str;
            int len = 0;
            for(int j = 0;j < m;j++){
                if(str[j] == '0'){
                    for(int k = 0;k < 4;k++)
                        graph[i][len++] = 0;
                    continue;
                }
                int tmp;
                if(isalpha(str[j]))
                    tmp = str[j] - 'a' + 10;
                else
                    tmp = str[j] - '0';
                for(int k = 0;k < 4;k++){
                    graph[i][len++] = num[tmp][k];
                }
            }
        }
        m *= 4;
        for(int i = 0;i < n;i++){
            if(graph[i][0] == 0)
                dfsZero(i,0);
            if(graph[i][m-1] == 0)
                dfsZero(i,m-1);
        }
        for(int j = 0;j < m;j++){
            if(graph[0][j] == 0)
                dfsZero(0,j);
            if(graph[n-1][j] == 0)
                dfsZero(n-1,j);
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(graph[i][j] == 1){
                    cnt = 0;
                    dfs(i,j);
                    for(int k = 0;k < 6;k++){
                        if(cnt == dic[k][0]){
                            con[ dic[k][1] ]++;
                            break;
                        }
                    }
                }
            }
        }
        cout << "Case " << ++cas << ": ";
        for(int i = 0;i < 6;i++){
            for(int j = 0;j < con[i];j++){
                cout << alpha[i];
            }
        }
        cout << endl;
    }
    return 0;
}