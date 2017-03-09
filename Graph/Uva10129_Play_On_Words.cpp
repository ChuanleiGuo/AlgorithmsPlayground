#include<cstdio>
#include<cstring>
#include<iostream>
#include<vector>
#include<string>

using namespace std;

vector<string> words;
int mat[30][30];
int cnt = 0;

bool dfs(int u) {
    if (cnt == words.size()) { return true; }
    for (int v = 0; v < 26; v ++) {
        if (mat[u][v] > 0) {
            cnt ++;
            mat[u][v] --;
            if (dfs(v)) { return true; }
            mat[u][v] ++;
            cnt --;
        }
    }
    return false;
}

int main() {
    int t;
    scanf("%d", &t);
    while(t --) {
        memset(mat, 0, sizeof(mat));
        words.clear();

        int n;
        scanf("%d", &n);

        for (int i = 0; i < n; i ++) {
            string word;
            cin >> word;
            words.push_back(word);
            mat[word[0] - 'a'][word[word.size() - 1] - 'a'] += 1;
        }

        bool possible = false;
        for (int i = 0; i < n; i ++) {
            cnt = 0;
            possible = dfs(words[i][0] - 'a');
            if (possible) { break; }
        }

        if (possible) {
            printf("Ordering is possible.\n");
        } else {
            printf("The door cannot be opened.\n");
        }
    }
    return 0;
}

