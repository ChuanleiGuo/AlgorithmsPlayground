from collections import Counter


class Solution(object):
    MAX_HAND = 6

    def findMinStep(self, board, hand):
        """
        :type board: str
        :type hand: str
        :rtype: int
        """
        letter_counter = Counter(hand)
        res = self.helper(board + "#", letter_counter)
        return -1 if res >= self.MAX_HAND else res
    
    def helper(self, board, letter_counter):
        board = self.remove_continuous_balls(board)
        if board == "#":
            return 0
        res = self.MAX_HAND

        i = 0
        for j in range(i, len(board)):
            if board[i] == board[j]:
                continue
            need = 3 - (j - i)
            if letter_counter.get(board[i], 0) >= need:
                letter_counter[board[i]] -= need
                res = min(res, need + self.helper(board[0:i] + board[j:], letter_counter))
                letter_counter[board[i]] += need
            i = j
        return res
    
    def remove_continuous_balls(self, board):
        i = 0
        for j in range(i, len(board)):
            if board[i] == board[j]:
                continue
            if j - i >= 3:
                return self.remove_continuous_balls(board[0:i] + board[j:])
            else:
                i = j
        return board
