#include<iostream>
#include<cstdio>
#include<cstring>

using namespace std;

int main() {
    int depth, num_balls;
    while(scanf("%d%d", &depth, &num_balls) == 2) {
        int k = 1;
        for (int i = 0; i < depth - 1; i ++) {
            if (num_balls % 2) {
                k = k * 2;
                num_balls = (num_balls + 1) / 2;
            } else {
                k = k * 2 + 1;
                num_balls /= 2;
            }
        }
        printf("%d\n", k);
    }
    return 0;
}