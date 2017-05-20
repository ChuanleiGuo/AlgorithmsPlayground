class Solution(object):
    def findRotateSteps(self, ring, key):
        """
        :type ring: str
        :type key: str
        :rtype: int
        """
        def dist(i, j):
            return min(abs(i - j), len(ring) - abs(i - j))
        pos = {}
        for i, c in enumerate(ring):
            if c in pos:
                pos[c].append(i)
            else:
                pos[c] = [i]
        state = {0: 0}
        for c in key:
            next_state = {}
            for j in pos[c]:
                next_state[j] = float("inf")
                for i in state:
                    next_state[j] = min(next_state[j], dist(i, j) + state[i])
            state = next_state
        return min(state.values()) + len(key)
