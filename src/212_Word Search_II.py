class Trie(object):
    def __init__(self):
        self.root = {}

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        node = self.root
        for c in word:
            if c not in node:
                node[c] = {}
            node = node[c]
        node['#'] = word


class Solution(object):
    def __build_trie(self, words):
        trie = Trie()
        for word in words:
            trie.insert(word)
        return trie

    def __dfs(self, board, row, col, trie_node, res):
        c = board[row][col]
        if c == '#' or c not in trie_node:
            return
        trie_node = trie_node[c]
        if '#' in trie_node:  # found one
            res.append(trie_node['#'])
            del trie_node['#']

        board[row][col] = '#'
        if row > 0:
            self.__dfs(board, row - 1, col, trie_node, res)
        if col > 0:
            self.__dfs(board, row, col - 1, trie_node, res)
        if row < len(board) - 1:
            self.__dfs(board, row + 1, col, trie_node, res)
        if col < len(board[0]) - 1:
            self.__dfs(board, row, col + 1, trie_node, res)
        board[row][col] = c

    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        res = []
        trie = self.__build_trie(words)
        for i in xrange(len(board)):
            for j in xrange(len(board[0])):
                self.__dfs(board, i, j, trie.root, res)
        return res
