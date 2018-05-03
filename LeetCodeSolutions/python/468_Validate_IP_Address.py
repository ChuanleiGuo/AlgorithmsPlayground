class Solution(object):
    def validIPAddress(self, IP):
        """
        :type IP: str
        :rtype: str
        """
        if self.is_valid_ip4(IP):
            return "IPv4"
        elif self.is_valid_ip6(IP):
            return "IPv6"
        else:
            return "Neither"

    def is_valid_ip4(self, ip):
        if len(ip) < 7:
            return False
        if ip[0] == '.' or ip[-1] == '.':
            return False
        tokens = ip.split('.')
        if len(tokens) != 4:
            return False
        for token in tokens:
            if not self.is_valide_ip4_token(token):
                return False
        return True

    def is_valide_ip4_token(self, token):
        if len(token) == 0:
            return False
        if token[0] == '0' and len(token) > 1:
            return False
        try:
            parsed_int = int(token)
            if parsed_int == 0 and token[0] != '0':
                return False
            if not (0 <= parsed_int <= 255):
                return False
            return True
        except ValueError:
            return False

    def is_valid_ip6(self, ip):
        if len(ip) < 15:
            return False
        if ip[0] == ':' or ip[-1] == ':':
            return False
        tokens = ip.split(':')
        if len(tokens) != 8:
            return False
        for token in tokens:
            if not self.is_valid_ip6_token(token):
                return False
        return True

    def is_valid_ip6_token(self, token):
        if len(token) > 4 or len(token) == 0:
            return False
        for c in token:
            is_digit = c.isdigit()
            is_upper_af = c.isupper() and (ord('A') <= ord(c) <= ord('F'))
            is_lower_af = c.islower() and (ord('a') <= ord(c) <= ord('f'))
            if not (is_digit or is_upper_af or is_lower_af):
                return False
        return True
