class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """

        def search(cur):
            if cur == n:
                add_answer()
            else:
                for i in range(n):
                    ok = True
                    rows[cur] = i
                    for j in range(cur):
                        if not is_valied(cur, j):
                            ok = False
                            break
                    if ok:
                        search(cur + 1)

        def is_valied(pre_row, cur_row):
            if rows[pre_row] == rows[cur_row] or \
                    pre_row - rows[pre_row] == cur_row - rows[cur_row] or \
                    pre_row + rows[pre_row] == cur_row + rows[cur_row]:
                return False
            else:
                return True

        def add_answer():
            ans = []

            for num in rows:
                res_str = ""
                for i in range(n):
                    if i == num:
                        res_str += "Q"
                    else:
                        res_str += "."
                ans.append(res_str)

            result.append(ans)

        result = []
        rows = [0] * n
        search(0)
        return result
print Solution().solveNQueens(4)
