#include <cstdio>
#include <cstring>
#include <cctype>
#include <queue>
#include <algorithm>

using namespace std;

typedef struct Node {
    int step;
    int ghosts[3];

    Node(int step = 0, int a = 0, int b = 0, int c = 0) {
        this->step = step;
        this->ghosts[0] = a;
        this->ghosts[1] = b;
        this->ghosts[2] = c;
    }
} Node;

char pic[20][20]; // the graph
int num[20][20]; // the indices of each non-wall cell
int vis[200][200][200];
int connected[200][200];
int idx = 0;
queue<Node> q;
Node goal;


void BFS() {
    memset(vis, 0, sizeof(vis));

    while (!q.empty()) {
        Node node = q.front();
        q.pop();
        vis[node.ghosts[0]][node.ghosts[1]][node.ghosts[2]] = 1;

        int &step = node.step, &a = node.ghosts[0], 
            &b = node.ghosts[1], &c = node.ghosts[2];
        if (a == goal.ghosts[0] && b == goal.ghosts[1] && c == goal.ghosts[2]) {
            goal.step = step;
            return;
        }

        for (int i = 0; i <= connected[a][0]; i++) {
            int t1 = (i == 0 ? a : connected[a][i]);
            for (int j = 0; j <= connected[b][0]; j++) {
                int t2 = (j == 0 ? b : connected[b][j]);
                for (int k = 0; k <= connected[c][0]; k++) {
                    int t3 = (k == 0 ? c : connected[c][k]);

                    if ((t1 && t2 && t1 == t2) || 
                        (t1 && t3 && t1 == t3) ||
                        (t2 && t3 && t2 == t3)) { continue; }
                    if (t1 && t2 && t1 == b && t2 == a) { continue; }
                    if (t1 && t3 && t1 == c && t3 == a) { continue; }
                    if (t2 && t3 && t2 == c && t3 == b) { continue; }

                    if (!vis[t1][t2][t3]) {
                        vis[t1][t2][t3] = 1;
                        Node next(step + 1, t1, t2, t3);
                        q.push(next);
                    }
                }
            }
        }
    }
}


int main() {
    int w, h, n;
    while (scanf("%d%d%d", &w, &h, &n) != EOF && w && h && n) {
        getchar();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                scanf("%c", &pic[i][j]);
            }
            getchar();
        }

        memset(connected, 0, sizeof(connected));
        idx = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (pic[i][j] != '#') {
                    num[i][j] = ++idx;
                } else {
                    num[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (num[i][j]) {
                    int &pos = num[i][j];
                    if (num[i + 1][j]) {
                        connected[pos][++connected[pos][0]] = num[i + 1][j];
                    }
                    if (num[i - 1][j]) {
                        connected[pos][++connected[pos][0]] = num[i - 1][j];
                    }
                    if (num[i][j - 1]) {
                        connected[pos][++connected[pos][0]] = num[i][j - 1];
                    }
                    if (num[i][j + 1]) {
                        connected[pos][++connected[pos][0]] = num[i][j + 1];
                    }
                }
            }
        }

        goal = Node(0, 0, 0, 0);
        Node start(0, 0, 0, 0);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (pic[i][j] == 'a') { start.ghosts[0] = num[i][j]; }
                if (pic[i][j] == 'b') { start.ghosts[1] = num[i][j]; }
                if (pic[i][j] == 'c') { start.ghosts[2] = num[i][j]; }

                if (pic[i][j] == 'A') { goal.ghosts[0] = num[i][j]; }
                if (pic[i][j] == 'B') { goal.ghosts[1] = num[i][j]; }
                if (pic[i][j] == 'C') { goal.ghosts[2] = num[i][j]; }
            }
        }
        q = queue<Node>();
        q.push(start);
        BFS();

        printf("%d\n", goal.step);
    }

    return 0;
}
