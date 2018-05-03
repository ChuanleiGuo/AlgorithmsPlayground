import string


class Solution(object):
    """
    :type beginWord: str
    :type endWord: str
    :type wordlist: Set[str]
    :rtype: List[List[int]]
    """
    def findLadders(self, begin, end, words_list):

        def construct_paths(begin, end, tree, path, paths):
            if begin == end:
                paths.append(path)
                return
            if begin in tree:
                for elem in tree[begin]:
                    construct_paths(elem, end, tree, path + [elem], paths)

        def add_path(tree, word, neigh, is_forw):
            if is_forw:
                tree[word] = tree.get(word, []) + [neigh]
            else:
                tree[neigh] = tree.get(neigh, []) + [word]

        def bfs_level(this_lev, oth_lev, tree, is_forw, words_set):
            if len(this_lev) == 0:
                return False
            if len(this_lev) > len(oth_lev):
                return bfs_level(oth_lev, this_lev, tree, not is_forw, words_set)
            for word in (this_lev | oth_lev):
                words_set.discard(word)
            next_lev = set()
            done = False
            while len(this_lev):
                word = this_lev.pop()
                for c in string.ascii_lowercase:
                    for index in range(len(word)):
                        neigh = word[:index] + c + word[index+1:]
                        if neigh in oth_lev:
                            done = True
                            add_path(tree, word, neigh, is_forw)
                        if not done and neigh in words_set:
                            next_lev.add(neigh)
                            add_path(tree, word, neigh, is_forw)
            return done or bfs_level(next_lev, oth_lev, tree, is_forw, words_set)

        tree, path, paths = {}, [begin], []
        is_found = bfs_level(set([begin]), set([end]), tree, True, words_list)
        construct_paths(begin, end, tree, path, paths)
        return paths
