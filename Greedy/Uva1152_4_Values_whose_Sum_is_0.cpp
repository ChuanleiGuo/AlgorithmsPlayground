#include <cstdio>
#include <vector>
#include <cstring>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> nums1, nums2;
vector<vector<int> > matrix(4, vector<int>());

int binary_search(int left, int right, int value) {
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int num = 0;

        if (nums2[mid] == value) {
            num = 1;
            for (int i = mid - 1; i >= 0 && nums2[i] == value; i--) {
                num++;
            }
            for (int i = mid + 1; i < nums2.size() && nums2[i] == value; i++) {
                num++;
            }
            return num;
        } else if (nums2[mid] > value) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return 0;
}

void init() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < matrix.size(); i++) {
        matrix[i].clear();
    }
    nums1.clear();
    nums2.clear();
    for (int i = 0; i < n; i++) {
        int a, b, c, d;
        scanf("%d %d %d %d", &a, &b, &c, &d);
        matrix[0].push_back(a);
        matrix[1].push_back(b);
        matrix[2].push_back(c);
        matrix[3].push_back(d);
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            nums1.push_back(matrix[2][i] + matrix[3][j]);
            nums2.push_back(-(matrix[0][i] + matrix[1][j]));
        }
    } 
    sort(nums2.begin(), nums2.end());
}

int main() {
    int t;
    int kase = 0;
    scanf("%d", &t);
    while (t--) {
        kase++;
        if (kase > 1) { printf("\n"); }
        init();
        int ans = 0;
        for (int i = 0; i < nums1.size(); i++) {
            ans += binary_search(0, nums1.size() - 1, nums1[i]);
        }
        printf("%d\n", ans);
    }
    return 0;
}