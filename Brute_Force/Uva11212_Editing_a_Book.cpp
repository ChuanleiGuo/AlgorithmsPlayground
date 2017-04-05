#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>

using namespace std;

string goal;
int n;

bool dfs(int d, int maxd, string now) {
    if (d == maxd) { return now == goal; }
    int h = 0;
    for (int i = 0; i < n - 1; i++) {
        if (now[i + 1] - now[i] != 1) {
            h += 1;
        }
    }

    if (h > 3 * (maxd - d)) { return false; }

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            for (int k = 0; k < i; k++) {
                string p = now.substr(0, k);
                string q = now.substr(i, j - i + 1);
                string r = now.substr(k, i - k);
                string t = now.substr(j + 1, n - j);
                if (dfs(d + 1, maxd, p + q + r + t)) {
                    return true;
                }
            }
        }
    }
    return false;
}

int main() {
    int kase = 0;
    while (scanf("%d", &n) != EOF && n) {
        string start = "";
        for (int i = 0; i < n; i++) {
            int a;
            scanf("%d", &a);
            start += char(a + '0');
        }

        goal = "";
        for (char c = '1'; c <= '0' + n; c++) {
            goal += c;
        }

        for (int maxd = 0; ; maxd++) {
            if (dfs(0, maxd, start)) {
                printf("Case %d: %d\n", ++kase, maxd);
                break;
            }
        }
    }
    return 0;
}