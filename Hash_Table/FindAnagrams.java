import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class FindAnagrams {
    public static List<List<String>> findAnagrams(List<String> words) {
        Map<String, List<String>> keyToWords = new HashMap<String, List<String>>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!keyToWords.containsKey(key)) {
                keyToWords.put(key, new ArrayList<String>());
            }

            keyToWords.get(key).add(word);
        }

        List<List<String>> anagramGroups = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : keyToWords.entrySet()) {
            if (entry.getValue().size() >= 2) {
                anagramGroups.add(entry.getValue());
            }
        }
        return anagramGroups;
    }

    private static void smallTest() {
        List<String> dictionary = Arrays.asList("debit card", "bad credit", "the morse code", "here come dots",
                "the eyes", "they see", "THL");
        List<List<String>> result = findAnagrams(dictionary);
        assert result.size() == 3;
    }

    private static String randString(int len) {
        StringBuilder ret = new StringBuilder();
        Random rnd = new Random();

        while (len-- > 0) {
            ret.append((char) (rnd.nextInt(26) + 97));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        smallTest();
        Random rnd = new Random();
        int n = rnd.nextInt(100000);
        Set<String> table = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            table.add(randString(rnd.nextInt(12) + 1));
        }
        List<String> dictionary = new ArrayList<>();
        for (String s : table) {
            dictionary.add(s);
        }
        findAnagrams(dictionary);
    }
}
