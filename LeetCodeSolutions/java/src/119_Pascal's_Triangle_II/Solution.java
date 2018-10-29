import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        long nCk = 1;
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++){
            result.add((int)nCk);
            nCk = nCk *(rowIndex-i)/(i+1);
        }
        return result;
    }
}