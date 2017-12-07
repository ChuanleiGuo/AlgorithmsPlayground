public class ReplaceAndRemove {
    public static int replaceAndREmove(int size, char[] s) {
        int writeIdx = 0, aCount = 0;
        for (int i = 0; i < size; i++) {
            if (s[i] != 'b') {
                s[writeIdx++] = s[i];
            }
            if (s[i] == 'a') {
                aCount++;
            }
        }

        int curIdx = writeIdx - 1;
        writeIdx = writeIdx + aCount - 1;
        final int finalSize = writeIdx + 1;
        while (curIdx >= 0) {
            if (s[curIdx] == 'a') {
                s[writeIdx --] = 'd';
                s[writeIdx --] = 'd';
            } else {
                s[writeIdx --] = s[curIdx];
            }
            curIdx--;
        }
        return finalSize;
    }
}
