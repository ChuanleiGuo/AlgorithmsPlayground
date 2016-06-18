import string
from collections import Set


class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: Set[str]
        :rtype: int
        """
        word_list = set(wordList)
        if beginWord in word_list:
            word_list.remove(beginWord)
        word_list.add(endWord)

        letters = str(string.lowercase)

        queue = [beginWord]
        level = 0

        while len(queue) != 0:
            size = len(queue)
            while size > 0:
                size -= 1

                word = queue.pop(0)
                if word == endWord:
                    return level + 1

                chars = list(word)

                for i in range(len(word)):
                    for letter in letters:
                        if letter != word[i]:
                            chars[i] = letter
                            new_word = "".join(chars)
                            if new_word in word_list:
                                word_list.remove(new_word)
                                queue.append(new_word)
                            chars[i] = word[i]

            level += 1

        return 0
