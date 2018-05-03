class Solution:
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        count = 0
        for i in range(len(flowerbed)):
            if count >= n:
                break
            if flowerbed[i] == 0:
                next_plot = 0 if i == len(flowerbed) - 1 else flowerbed[i + 1]
                prev_plot = 0 if i == 0 else flowerbed[i - 1]
                if next_plot == 0 and prev_plot == 0:
                    flowerbed[i] = 1
                    count += 1

        return count == n
 