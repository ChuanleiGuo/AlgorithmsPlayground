#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

const int MAXN = 31;

struct Node {
    int x;
    int y;
    int z;
    Node(int x, int y, int z): x(x), y(y), z(z) {}
    Node() {};
    bool operator < (const Node &n) const {
        return (this->x < n.x && this->y < n.y) ||
               (this->x < n.y && this->y < n.x);
    }
};

vector<Node> vec;
int n;
int d[MAXN * 3];
int g[MAXN * 3][MAXN * 3];

int dp(int i, int height) {
    int &ans = d[i];
    if (ans > 0) { return ans; }
    ans = height;
    for (int j = 0; j < 3 * n; j++) {
        if (g[i][j]) {
            ans = max(ans, dp(j, vec[j].z) + height);
        }
    }
    return ans;
}

int main() {
    int cnt = 0;
    while (scanf("%d", &n) != EOF && n) {
        vec.clear();
        memset(d, 0, sizeof(d));
        memset(g, 0, sizeof(g));
        for (int i = 0; i < n; i++) {
            int x, y, z;
            scanf("%d%d%d", &x, &y, &z);
            vec.push_back(Node(x, y, z));
            vec.push_back(Node(x, z, y));
            vec.push_back(Node(z, y, x));
        }
        sort(vec.begin(), vec.end());

        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                if (vec[i] < vec[j]) {
                    g[i][j] = 1;
                }
            }
        }
        int res = -1;
        for (int i = 0; i < 3 * n; i++) {
            res = max(res, dp(i, vec[i].z));
        }
        printf("Case %d: maximum height = %d\n", ++cnt, res);
    }
    return 0;
}