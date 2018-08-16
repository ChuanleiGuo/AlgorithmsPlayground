import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    private List<String> res;

    final private String[] letterMap = {
        "",
        " ",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    private void findCombinations(String digits, int index, String inter) {
        if (index == digits.length()) {
            res.add(inter);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombinations(digits, index + 1, inter + letters.charAt(i));
        }
        return;
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return res;
        }
        findCombinations(digits, 0, "");
        return res;
    }
}