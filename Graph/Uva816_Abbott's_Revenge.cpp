#include<cstdio>
#include<cstring>
#include<queue>
#include<vector>

using namespace std;

const int MAXN = 100;
const char *dirs = "NESW";
const char *turns = "FLR";

struct Node {
    int r, c, dir;
    Node(int r = 0, int c = 0, int dir = 0): r(r), c(c), dir(dir) {}
};
char sample[MAXN];
int has_edge[10][10][4][3];
int d[10][10][4];
Node p[10][10][4];
int r0, c0, dir;
int r1, c1;
int r2, c2;

int dir_id(char c) { return strchr(dirs, c) - dirs; }
int turn_id(char c) { return strchr(turns, c) - turns; }

const int dr[] = {-1, 0, 1, 0};
const int dc[] = {0, 1, 0, -1};

Node walk(const Node &u, int turn) {
    int dir = u.dir;
    if (turn == 1) { dir = (dir + 3) % 4; }
    if (turn == 2) { dir = (dir + 1) % 4; }
    return Node(u.r + dr[dir], u.c + dc[dir], dir);
}

bool inside(int i, int j) {
    return i > 0 && i < 10 && j > 0 && j < 10;
}

void print_ans(Node u) {
    vector<Node> nodes;
    while(1) {
        nodes.push_back(u);
        if (d[u.r][u.c][u.dir] == 0) { break; }
        u = p[u.r][u.c][u.dir];
    }
    nodes.push_back(Node(r0, c0, dir));

    int cnt = 0;
    for (int i = nodes.size() - 1; i >= 0; i --) {
        if (cnt % 10 == 0) { printf(" "); }
        printf(" (%d,%d)", nodes[i].r, nodes[i].c);
        if (++cnt % 10 == 0) { printf("\n"); }
    }
    if (nodes.size() % 10 != 0) { printf("\n"); }
}

void solve() {
    queue<Node> q;
    memset(d, -1, sizeof(d));
    Node u(r1, c1, dir);
    d[u.r][u.c][u.dir] = 0;
    q.push(u);
    while (! q.empty()) {
        Node u = q.front();
        q.pop();
        if (u.r == r2 && u.c == c2) {
            print_ans(u);
            return;
        }
        for (int i = 0; i < 3; i ++) {
            Node v = walk(u, i);
            if (has_edge[u.r][u.c][u.dir][i] && inside(v.r, v.c) && d[v.r][v.c][v.dir] < 0) {
                d[v.r][v.c][v.dir] = d[u.r][u.c][u.dir] + 1;
                p[v.r][v.c][v.dir] = u;
                q.push(v);
            }
        }
    }
    printf("  No Solution Possible\n");
}

void read_input() {
    scanf("%d%d", &r0, &c0);getchar();
    dir = dir_id(getchar());
    r1 = r0 + dr[dir];
    c1 = c0 + dc[dir];
    scanf("%d%d", &r2, &c2);
    int i, j;
    memset(has_edge, 0, sizeof(has_edge));
    while (~scanf("%d", &i) && i) {
        scanf("%d", &j);getchar();
        char c;
        while ((c = getchar()) != '*') {
            int dirc = dir_id(c);
            char t;
            while ((t = getchar()) != ' ') {
                int turnt = turn_id(t);
                has_edge[i][j][dirc][turnt] = 1;
            }
        }
    }
}


int main() {
    while (~scanf("%s", sample) && strcmp(sample, "END")) {
        printf("%s\n", sample);
        read_input();
        solve();
    }
    return 0;
}