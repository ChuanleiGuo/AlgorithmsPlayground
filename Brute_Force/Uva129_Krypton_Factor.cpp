#include <cstdio>
#include <iostream>
#include <vector>

using namespace std;

const int maxn = 100;
vector<int> s(maxn, 0);
int n, l;
int cnt = 0;

void print_res(int length) {
    int group = length / 4;
    int rest = length % 4;

    for (int i = 0; i < group; i ++) {
        if (i != 0 && (i % 16 == 0)) {
            printf("\n");
        } else if (i > 0){
            printf(" ");
        }
        for (int j = 0; j < 4; j ++) {
            printf("%c", 'A' + s[4 * i + j]);
        }
    }
    if (rest) { 
        if (group == 16) { printf("\n"); }
        else if (group) { printf(" "); }
    }
    for (int i = 0; i < rest; i ++) {
        printf("%c", 'A' + s[4 * group + i]);
    }
    printf("\n%d\n", length);
}

int dfs(int cur) {
    if (cnt ++ == n) {
        print_res(cur);
        return 0;
    }
    for (int i = 0; i < l; i ++) {
        s[cur] = i;
        bool ok = 1;
        for (int j = 1; j * 2 <= cur + 1; j ++) {
            bool equal = true;
            for (int k = 0; k < j; k ++) {
                if (s[cur - k] != s[cur - k - j]) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                ok = false;
                break;
            }
        }
        if (ok && !dfs(cur + 1)) {
            return 0;
        }
    }
    return 1;
}

int main() {
    // freopen("./input.txt", "r", stdin);
    // freopen("./output.txt", "w", stdout);
    while (scanf("%d%d", &n, &l) != EOF && n && l) {
        s = vector<int>(maxn, 0);
        cnt = 0;

        dfs(0);

    }
    return 0;
}
