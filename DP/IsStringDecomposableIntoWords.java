import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class IsStringDecomposableIntoWords {

    public static List<String> decomposeIntoDictionaryWords(String domain, Set<String> dictionary) {
        int[] lastLength = new int[domain.length()];
        Arrays.fill(lastLength, -1);

        for (int i = 0; i < domain.length(); i++) {
            if (dictionary.contains(domain.substring(0, i + 1))) {
                lastLength[i] = i + 1;
            }

            if (lastLength[i] == -1) {
                for (int j = 0; j < i; j++) {
                    if (lastLength[j] != -1 && dictionary.contains(domain.substring(j + 1, i + 1))) {
                        lastLength[i] = i - j;
                        break;
                    }
                }
            }
        }

        List<String> decompositions = new ArrayList<>();
        if (lastLength[lastLength.length - 1] != -1) {
            int idx = domain.length() - 1;
            while (idx >= 0) {
                decompositions.add(domain.substring(idx + 1 - lastLength[idx], idx + 1));
                idx -= lastLength[idx];
            }
            Collections.reverse(decompositions);
        }
        return decompositions;
    }
}
