class Solution(object):
    def palindromePairs(self, words):
        """
        :type words: List[str]
        :rtype: List[List[int]]
        """

        def is_palindrome(word):
            left, right = 0, len(word) - 1

            while left <= right:
                if word[left] != word[right]:
                    return False
                left += 1
                right -= 1

            return True

        res = []

        if not words or len(words) < 2:
            return res

        words_to_pos = {}
        for idx, word in enumerate(words):
            words_to_pos[word] = idx

        for i in range(len(words)):
            for j in range(len(words[i]) + 1):

                str1 = words[i][0:j]
                str2 = words[i][j:]

                if is_palindrome(str1):
                    str2_rvs = str2[::-1]
                    if str2_rvs in words_to_pos and words_to_pos[str2_rvs] != i:
                        l = [words_to_pos[str2_rvs], i]
                        res.append(l)

                if is_palindrome(str2):
                    str1_rvs = str1[::-1]
                    if str1_rvs in words_to_pos and words_to_pos[str1_rvs] != i and \
                            len(str2) != 0:
                        l = [i, words_to_pos[str1_rvs]]
                        res.append(l)
        return res
print Solution().palindromePairs(["bat", "tab", "cat"])
print Solution().palindromePairs(["abcd", "dcba", "lls", "s", "sssll"])
