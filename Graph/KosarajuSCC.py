import sys
import os
from pprint import pprint
import threading

class Graph(object):

    def __init__(self, filepath=None):
        self._adj_list = []
        self._reverse_adj_list = []
        if filepath:
            self._read(filepath)

    def _read(self, filepath):
        with open(filepath) as f:
            lines = f.readlines()

        lines = [l for l in lines if len(l) > 0]

        for line in lines:
            num1, num2 = line.split()
            v_from = int(num1)
            v_to = int(num2)
            max_v = max(v_from, v_to)

            while (len(self._adj_list) < max_v):
                self._adj_list.append([])

            while (len(self._reverse_adj_list) < max_v):
                self._reverse_adj_list.append([])

            self._adj_list[v_from - 1].append(v_to - 1)
            self._reverse_adj_list[v_to - 1].append(v_from - 1)

    @property
    def reverse(self):
        return self._reverse_adj_list

    @property
    def graph(self):
        return self._adj_list

class KosarajuSCC(object):

    def __init__(self, graph):
        self.graph = graph.graph
        self.graph_rev = graph.reverse

        self.t = 0
        self.n = len(self.graph_rev)
        self.explored = [False] * self.n
        self.sorted_by_finish_time = [None] * self.n
        self.scc_size = 0

    def _dfs_loop1(self):
        self.t = 0
        self.explored = [False] * self.n
        self.sorted_by_finish_time = [None] * self.n

        def dfs(graph_rev, i):
            self.explored[i] = True
            for v in graph_rev[i]:
                if not self.explored[v]:
                    dfs(graph_rev, v)

            self.sorted_by_finish_time[self.t] = i
            self.t += 1

        for i in reverse(range(self.n)):
            if not self.explored[i]:
                dfs(self.graph_rev, i)

    def _dfs_loop2(self):
        self.explored = [False] * len(self.graph)
        res = []

        def dfs(graph, i):
            self.explored[i] = True

            for v in graph[i]:
                if not self.explored[v]:
                    dfs(graph, v)

            self.scc_size += 1

        for i in reversed(range(len(self.graph))):
            if not self.explored[self.sorted_by_finish_time[i]]:
                self.scc_size = 0
                dfs(self.graph, self.sorted_by_finish_time[i])
                res.append(self.scc_size)

        return res

    def kosaraju_scc_sizes(self):
        self._dfs_loop1()
        res = self._dfs_loop2()

        return res


def main():
    CURDIR = os.path.dirname(os.path.abspath(__file__))
    FILEPATH = os.path.join(CURDIR, "SCC.txt")
    print "start"
    graph = Graph(FILEPATH)
    print "read graph"
    print "calculating scc sizes"
    res = KosarajuSCC(graph).kosaraju_scc_sizes()
    print ','.join(map(lambda x: str(x), sorted(res)[::-1][:5]))

if __name__ == '__main__':
    threading.stack_size(67108864)
    sys.setrecursionlimit(2 ** 20)
    thread = threading.Thread(target=main)
    thread.start()
