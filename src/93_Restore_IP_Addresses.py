class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        result = []
        self.__dfs(s, 0, 0, "", result)
        return result

    def __dfs(self, s, idx, count, path, result):
        if count >= 4:
            if idx == len(s):
                result.append(str(path[0: -1]))
            return
        for i in range(idx + 1, len(s) + 1):
            if self.__is_valide(s[idx: i]):
                self.__dfs(s, i, count + 1, path + s[idx: i] + ".", result)

    def __is_valide(self, s):
        if s[0] == "0" and s != "0":
            return False
        return len(s) < 4 and 0 <= int(s) < 256
