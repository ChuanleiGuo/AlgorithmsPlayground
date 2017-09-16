#include <cstdio>
#include <string>
#include <cctype>
#include <iostream>
#include <map>

using namespace std;

const int maxn = 60010;
int T, cas, cnt;
char expr[maxn * 5], *p;
int done[maxn];

struct Node {
    string s;
    int hash, left, right;
    bool operator < (const Node &b) const {
        if (hash != b.hash) { return hash < b.hash; }
        if (left != b.left) { return left < b.left; }
        return right < b.right;
    }
} nodes[maxn];

map<Node, int> dict;

int parse() {
    int id = cnt++;
    Node &u = nodes[id];
    u.left = u.right = -1;
    u.s = "";
    u.hash = 0;

    while (isalpha(*p)) {
        u.hash = u.hash * 27 + *p - 'a' + 1;
        u.s.push_back(*p);
        p++;
    }
    if (*p == '(') {
        p++;
        u.left = parse();
        p++;
        u.right = parse();
        p++;
    }
    if (dict.count(u) != 0) {
        id--; cnt--;
        return dict[u];
    }
    return dict[u] = id;
}

void print(int v) {
    if (done[v] == cas) { printf("%d", v + 1); }
    else {
        done[v] = cas;
        printf("%s", nodes[v].s.c_str());
        if (nodes[v].left != -1) {
            putchar('(');
            print(nodes[v].left);
            putchar(',');
            print(nodes[v].right);
            putchar(')');
        }
    }
}

int main() {
    scanf("%d", &T);
    for (cas = 1; cas <= T; cas++) {
        dict.clear();
        cnt = 0;
        scanf("%s", expr);
        p = expr;
        print(parse());
        putchar(10);
    }
    return 0;
}