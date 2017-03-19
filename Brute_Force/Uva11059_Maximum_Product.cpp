#include<cstdio>
#include<algorithm>
#include<iostream>

using namespace std;

long long s[20][20];
int t[20];

int main() {
    int  n;
    int casenum = 0;
    while (scanf("%d", &n) == 1) {
        scanf("%d", &t[0]);
        for (int i = 1; i < n; i++) {
            scanf("%d", &t[i]);
        }
        
        for(int i = 0; i < n; i++)
        {
            s[i][i] = t[i];
            for (int j = i + 1; j < n; j++) {
                s[i][j] = s[i][j-1] * t[j];
            }
        }
        long long  max = t[0];
        for (int i = 0; i < n; i++) {
            max = max > s[0][i] ? max : s[0][i];
            for (int j = i + 1; j < n; j++) {
                max = max > s[j - i][j] ? max : s[j - i][j];
            }
        }
        if (max <= 0) {
            printf("Case #%d: The maximum product is %lld.\n", ++casenum, max - max);
        }
        else{
            printf("Case #%d: The maximum product is %lld.\n", ++casenum, max);
        }
        printf("\n");
    }
    return 0;
}
