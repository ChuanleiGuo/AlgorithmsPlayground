#include<iostream>
#include<cstring>
#include<cstdio>

using namespace std;

const int maxn = 1024 + 30;
const int len = 32;
int pic[len][len], cnt;
char s[maxn];

void draw(const char *s, int& p, int r, int c, int w) {
    char ch = s[p ++];
    if (ch == 'p') {
        draw(s, p, r, c + w / 2, w / 2);
        draw(s, p, r, c, w / 2);
        draw(s, p, r + w / 2, c, w / 2);
        draw(s, p, r + w / 2, c + w / 2, w / 2);
    } else if (ch == 'f') {
        for (int i = r; i < r + w; i ++) {
            for (int j = c; j < c + w; j ++) {
                if (pic[i][j] == 0) {
                    pic[i][j] = 1;
                    cnt += 1;
                }
            }
        }
    }
}

int main() {
    int t;
    scanf("%d", &t);
    while (t --) {
        memset(pic, 0, sizeof(pic));
        cnt = 0;
        for (int i = 0; i < 2; i ++) {
            scanf("%s", s);
            int p = 0;
            draw(s, p, 0, 0, len);
        }
        printf("There are %d black pixels.\n", cnt);
    }
    return 0;
}