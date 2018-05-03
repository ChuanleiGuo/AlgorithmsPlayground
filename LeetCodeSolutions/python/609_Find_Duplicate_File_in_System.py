from collections import defaultdict


class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        content_dict = defaultdict(list)

        for path in paths:
            components = path.split()
            root = components[0]

            for file_info in components[1:]:
                file_name, _, content = file_info.partition('(')
                content_dict[content[:-1]].append(root + '/' + file_name)

        return [x for x in content_dict.values() if len(x) > 1]
