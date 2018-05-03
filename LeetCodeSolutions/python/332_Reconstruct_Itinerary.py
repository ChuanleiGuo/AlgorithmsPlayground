class Solution(object):
    def findItinerary(self, tickets):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        from collections import defaultdict
        flights = defaultdict(list)
        for a, b in sorted(tickets)[::-1]:
            flights[a] += b,

        route = []

        def visit(airport):
            while flights[airport]:
                visit(flights[airport].pop())
            route.append(airport)

        visit('JFK')

        return route[::-1]
