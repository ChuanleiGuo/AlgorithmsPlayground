#include <cstdio>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

const int MAXN = 5100;
int n;
struct Node {
    int l, r, id;

    friend bool operator < (const Node &a, const Node &b) {
        if (a.l != b.l) { 
            return a.l > b.l;
        }
        return a.r > b.r;
    }
} arrx[MAXN], arry[MAXN];

int ans[MAXN][2];

bool check(Node *arr, int pos) {
    priority_queue<Node> q;
    for (int i = 0; i < n; i++) { q.push(arr[i]); }
    int maxx = 0;
    while (!q.empty()) {
        Node tmp = q.top();
        q.pop();
        if (tmp.r < maxx) { return false; }
        if (tmp.l < maxx) {
            tmp.l = maxx;
            q.push(tmp);
            continue;
        }
        int cur = max(maxx, tmp.l);
        ans[tmp.id][pos] = cur;
        maxx = cur + 1; 
    }
    return true;
}

int main() {
    while (scanf("%d", &n) != EOF && n) {
        for (int i = 0; i < n; i++) {
            scanf("%d%d%d%d", &arrx[i].l, &arry[i].l, &arrx[i].r, &arry[i].r);
            arrx[i].id = i;
            arry[i].id = i;
        }
        if (check(arrx, 0) && check(arry, 1)) {
            for (int i = 0; i < n; i++) {
                printf("%d %d\n", ans[i][0], ans[i][1]);
            }
        } else {
            printf("IMPOSSIBLE\n");
        }
    }
    return 0;
}
