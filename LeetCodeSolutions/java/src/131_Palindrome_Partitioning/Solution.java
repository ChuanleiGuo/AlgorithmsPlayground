import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> curList = new ArrayList<>();
        backTrack(s, 0, result, curList);
        return result;
    }

    private void backTrack(String s, int idx, List<List<String>> resList, List<String> curList) {
        if (curList.size() > 0 && idx >= s.length()) {
            List<String> r = new ArrayList<>(curList);
            resList.add(r);
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                if (idx == i) {
                    curList.add(Character.toString(s.charAt(i)));
                } else {
                    curList.add(s.substring(idx, i + 1));
                }
                backTrack(s, i + 1, resList, curList);
	            curList.remove(curList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int l, int r){
        if (l == r) {
            return true;
        }
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}