from collections import deque


class Solution:
    def predictPartyVictory(self, senate):
        """
        :type senate: str
        :rtype: str
        """
        r_queue, d_queue = deque(), deque()
        for idx, s in enumerate(senate):
            if s == 'R':
                r_queue.append(idx)
            else:
                d_queue.append(idx)

        while len(r_queue) and len(d_queue):
            r_idx, d_idx = r_queue.popleft(), d_queue.popleft()
            if r_idx < d_idx:
                r_queue.append(r_idx + len(senate))
            else:
                d_queue.append(d_idx + len(senate))

        return "Radiant" if len(r_queue) else "Dire"
