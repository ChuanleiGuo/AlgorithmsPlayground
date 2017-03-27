class Solution(object):

    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """

        def search(cur):
            if cur == n:
                total[0] += 1
            else:
                for i in range(n):
                    flag = True
                    rows[cur] = i
                    for j in range(cur):
                        if not is_valid(cur, j):
                            flag = False
                            break
                    if flag:
                        search(cur + 1)

        def is_valid(pre_row, cur_row):
            if rows[pre_row] == rows[cur_row] or \
                    pre_row - rows[pre_row] == cur_row - rows[cur_row] or \
                    pre_row + rows[pre_row] == cur_row + rows[cur_row]:
                return False
            else:
                return True

        total = [0]
        rows = [0] * n
        search(0)
        return total[0]

print Solution().totalNQueens(4)
