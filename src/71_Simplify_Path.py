class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        coms = path.split('/')
        stack = []
        for com in coms:
            if com == '.' or com == '/' or com == '':
                continue
            elif com == '..':
                if len(stack) != 0:
                    stack.pop()
            else:
                stack.append(com)
        return '/' + '/'.join(stack)


