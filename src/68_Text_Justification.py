class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        ans = []
        i = 0
        n = len(words)
        while i < n:
            len_word = len(words[i])
            j = i + 1
            while j < n and len_word + 1 + len(words[j]) <= maxWidth:
                len_word += (len(words[j]) + 1)
                j += 1

            line = words[i]
            # last line
            if j == n:
                for k in range(i + 1, n):
                    if k < n:
                        line += (" " + words[k])

                while len(line) < maxWidth:
                    line += " "
            else:
                extra_white = maxWidth - len_word
                num_white = j - i - 1

                # have only one word
                if num_white == 0:
                    while len(line) < maxWidth:
                        line += " "
                else:
                    for k in range(i + 1, j):
                        line += " "
                        for p in range(extra_white / num_white):
                            line += " "
                        if k - i <= extra_white % num_white:
                            line += " "
                        line += words[k]

            ans.append(line)
            i = j

        return ans
