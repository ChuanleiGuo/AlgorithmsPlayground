class WordDictionary(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.root = {}

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        node = self.root
        for c in word:
            if c not in node:
                node[c] = {}
            node = node[c]
        node['#'] = '#'

    def search(self, word):
        """
        Returns if the word is in the data structure. A word could
        contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        def find(word, node):
            if not word:
                return '#' in node

            c, word = word[0], word[1:]
            if c != '.':
                return c in node and find(word, node[c])
            return any(find(word, d) for d in node.values() if d != '#')
        return find(word, self.root)

