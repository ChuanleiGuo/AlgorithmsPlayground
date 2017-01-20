#include <cstdio>
#include <vector>
#include <iostream>

using namespace std;

class ZigZag {
public:
    int longestZigZag(vector<int>& sequence) {
        if (sequence.size() == 1) {
            return 1;
        }
        vector<vector<int> > z;
        for (int i = 0; i < sequence.size(); i ++) {
            z.push_back(vector<int>{0, 0});
        }
        z[0][0] = 1;
        z[0][1] = 1;

        for (int i = 1; i < z.size(); i ++) {
            for (int j = i - 1; j >= 0; j --) {
                if (sequence[j] < sequence[i]) {
                    z[i][0] = max(z[j][1] + 1, z[i][0]);
                }
                if (sequence[j] > sequence[i]) {
                    z[i][1] = max(z[j][0] + 1, z[i][1]);
                }
            }
        }
        return max(z[z.size() - 1][0], z[z.size() - 1][1]);
    }
};
