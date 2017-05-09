#include <cstdio>
#include <cstdlib>

using namespace std;

int main() {
    int n;
    while (scanf("%d", &n) != EOF && n) {
        long long ans = 0, last = 0;
        for (int i = 0; i < n; i++) {
            int a;
            scanf("%d", &a);
            ans += abs(last);
            last += a;
        }
        printf("%lld\n", ans);
    }
    return 0;
}