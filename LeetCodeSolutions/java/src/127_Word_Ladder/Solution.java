import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) { return 0; }
        wordDict.add(endWord);
        Deque<String> toVisit = new LinkedList<>();
        addNextWords(beginWord, wordDict, toVisit);
        int dist = 2;
        while (!toVisit.isEmpty()) {
            int num = toVisit.size();
            for (int i = 0; i < num; i++) {
                String word = toVisit.pollFirst();
                if (word.equals(endWord)) {
                    return dist;
                }
                addNextWords(word, wordDict, toVisit);
            }
            dist++;
        }

        return 0;
    }

    private void addNextWords(String word, Set<String> wordDict, Deque<String> toVisit) {
        wordDict.remove(word);
        for (int i = 0; i < word.length(); i++) {
            char[] charArr = word.toCharArray();
            for (int k = 0; k < 26; k++) {
                charArr[i] = (char)('a' + k);
                String newWord = new String(charArr);
                if (wordDict.contains(newWord)) {
                    toVisit.addLast(newWord);
                    wordDict.remove(newWord);
                }
            }
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int r = new Solution().ladderLength(beginWord, endWord, wordList);
        System.out.println(r);
    }
}