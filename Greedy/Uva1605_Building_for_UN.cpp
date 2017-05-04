#include <cstdio>
#include <iostream>

using namespace std;

char intToChar(int x) {
    if (x > 25) {
        return x - 26 + 'A';
    }
    return x + 'a';
}

int main() {
    int n;
    while (scanf("%d", &n) != EOF) {
        printf("2 %d %d\n", n, n);
        for (int i = 0; i < n; i++) {
            char c = intToChar(i);
            for (int j = 0; j < n; j++) {
                printf("%c", c);
            }
            printf("\n");
        }
        printf("\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = intToChar(j);
                printf("%c", c);
            }
            printf("\n");
        }
        printf("\n");
    }

    return 0;
}