class Solution:
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        res = 2 ** 31 - 1
        for i in range(len(special)):
            offer = special[i]
            invalid_offer = False
            for j in range(len(needs)):
                remain = needs[j] - offer[j]
                needs[j] = remain
                if not invalid_offer and remain < 0:
                    invalid_offer = True
            
            if not invalid_offer:
                res = min(res, self.shoppingOffers(price, special, needs) + offer[-1])

            for j in range(len(needs)):
                remain = needs[j] + offer[j]
                needs[j] = remain

        non_offer = 0
        for i in range(len(needs)):
            non_offer += price[i] * needs[i]
        return min(res, non_offer)