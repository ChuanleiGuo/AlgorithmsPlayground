class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if board is None or len(board) == 0 or len(board[0]) == 0 or word is None:
            return False
        visited = [[False] * len(board[0]) for _ in range(len(board))]
        for r in range(len(board)):
            for c in range(len(board[0])):
                if board[r][c] == word[0]:
                    if self.__dfs(board, word, 0, r, c, visited):
                        return True

        return False

    def __dfs(self, board, word, start, i, j, visited):
        if board[i][j] == word[start]:
            visited[i][j] = True
            if start == len(word) - 1:
                return True
            if i - 1 >= 0 and not visited[i - 1][j]:
                if self.__dfs(board, word, start + 1, i - 1, j, visited):
                    return True
            if j - 1 >= 0 and not visited[i][j - 1]:
                if self.__dfs(board, word, start + 1, i, j - 1, visited):
                    return True
            if i + 1 < len(board) and not visited[i + 1][j]:
                if self.__dfs(board, word, start + 1, i + 1, j, visited):
                    return True
            if j + 1 < len(board[0]) and not visited[i][j + 1]:
                if self.__dfs(board, word, start + 1, i, j + 1, visited):
                    return True
        visited[i][j] = False
        return False
