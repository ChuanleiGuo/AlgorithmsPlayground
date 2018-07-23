import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String comp : components) {
            if (comp.equals("..") && stack.size() != 0) {
                stack.pop();
            } else if (!skip.contains(comp)) {
                stack.push(comp);
            }
        }
        String res = "";
        for (String dir : stack) { res = "/" + dir + res; }
        return res.isEmpty() ? "/" : res;
    }
}
