class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """

        def length_of_LIS(envs):

            def index_of_tail(envs, tails, key):
                start, end = 0, len(tails) - 1
                while start <= end:
                    mid = start + ((end - start) >> 1)
                    if envs[tails[mid]][1] >= key[1]:
                        end = mid - 1
                    else:
                        start = mid + 1
                return start

            tails = []
            for i, env in enumerate(envs):
                idx = index_of_tail(envs, tails, env)
                if idx >= len(tails):
                    tails.append(i)
                else:
                    tails[idx] = i

            return len(tails)

        def f(x, y):
            return -1 if (x[0] < y[0] or x[0] == y[0] and x[1] > y[1]) else 1

        envelopes.sort(cmp=f)
        return length_of_LIS(envelopes)
