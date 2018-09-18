import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int idxG = 0, idxS = 0;
        while (idxG < g.length && idxS < s.length) {
            if (g[idxG] <= s[idxS]) {
                idxG++;
                idxS++;
            } else {
                idxS++;
            }
        }
        return idxG;
    }
}