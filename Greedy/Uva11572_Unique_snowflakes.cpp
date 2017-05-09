#include <cstdio>
#include <vector>
#include <set>

using namespace std;

int main() {
    int kase;
    scanf("%d", &kase);
    while (kase--) {
        int n;
        scanf("%d", &n);
        vector<int> arr;
        for (int i = 0; i < n; i++) {
            int num;
            scanf("%d", &num);
            arr.push_back(num);
        }

        set<int> s;
        int left = 0, right = 0, ans = 0;
        while (right < n) {
            while (right < n && s.count(arr[right]) == 0) {
                s.insert(arr[right++]);
            }
            ans = max(ans, right - left);
            s.erase(arr[left++]);
        }
        printf("%d\n", ans);
    }
    return 0;
}