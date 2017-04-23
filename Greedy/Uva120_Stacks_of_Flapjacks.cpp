#include<algorithm>
#include<cstdio>
#include<iostream>
#include<sstream>
#include<vector>
 
using namespace std;
 
int n;
vector<int> pancakes;
string line;
stringstream ss;
 
void flip(vector<int> *p, int s) {
    int end = s + ((*p).size() - s) / 2;
    for(int i = s; i < end; i++) {
        int l = (*p).size() - (i - s) - 1;
        swap((*p)[i], (*p)[(*p).size() - (i - s) - 1]);
    }
}
 
vector<int> flip_sort(vector<int> pancakes) {
    // basic algorithm outline
    // start with the (current) smallest element of the stack
    // if it's not at the end, flip the stack so that it's at the end
    // flip the stack from the first position after already sorted ones
     
    vector<int> sorted, flips;
 
    for(int i = 0; i < pancakes.size(); i++)
        sorted.push_back(pancakes[i]);
    sort(sorted.begin(), sorted.end(), greater<int>());
 
    int s_pos = 0; // starting position
    for(int i = 0; i < sorted.size(); i++) {
 
        if(pancakes[s_pos] == sorted[i]) {
            s_pos++;
            continue;
        }
        for(int j = s_pos; j < pancakes.size(); j++) {
            if(pancakes[j] == sorted[i]) {
                if(j == pancakes.size() - 1) {
                    // flip from s_pos
                    flip(&pancakes, s_pos);
                    flips.push_back(s_pos + 1);
                } else {
                    // flip from j, then from s_pos
                    flip(&pancakes, j);
                    flip(&pancakes, s_pos);
                    flips.push_back(j + 1);
                    flips.push_back(s_pos + 1);
                }
                break;
            }
        }
        s_pos++;
    }
 
    flips.push_back(0);
    return flips;
}
 
int main() {
    while(getline(cin, line)) {
        ss.clear();
        pancakes.clear();
        ss.str(line);
        while(ss >> n) {
            pancakes.push_back(n);
        }
        
        // flip pancakes array so bottom is first element
        for(int i = 0; i < pancakes.size() / 2; i++) {
            swap(pancakes[i], pancakes[pancakes.size() - 1 - i]);
        }
        vector<int> flips = flip_sort(pancakes);
 
        for(int i = pancakes.size() - 1; i > 0; i--)
            printf("%d ", pancakes[i]);
        printf("%d\n", pancakes[0]);
        for(int i = 0; i < flips.size() - 1; i++)
            printf("%d ", flips[i]);
        printf("%d\n", flips[flips.size() - 1]);
    }
}