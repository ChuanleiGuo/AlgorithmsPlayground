import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayWithRepeats {
    private static class Person {
        public Integer age;
        public String name;

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void groupByAge(List<Person> persons) {
        Map<Integer, Integer> ageToCount = new HashMap<>();
        for (Person p : persons) {
            if (ageToCount.containsKey(p.age)) {
                ageToCount.put(p.age, ageToCount.get(p.age) + 1);
            } else {
                ageToCount.put(p.age, 1);
            }
        }
        Map<Integer, Integer> ageToOffset = new HashMap<>();
        int offset = 0;
        for (Map.Entry<Integer, Integer> kc : ageToCount.entrySet()) {
            ageToOffset.put(kc.getKey(), offset);
            offset += kc.getValue();
        }

        while (!ageToOffset.isEmpty()) {
            Map.Entry<Integer, Integer> from = ageToOffset.entrySet().iterator().next();
            Integer toAge = persons.get(from.getValue()).age;
            Integer toValue = ageToOffset.get(toAge);
            Collections.swap(persons, from.getValue(), toValue);

            Integer count = ageToCount.get(toAge) - 1;
            ageToCount.put(toAge, count);
            if (count > 0) {
                ageToOffset.put(toAge, toValue + 1);
            } else {
                ageToOffset.remove(toAge);
            }
        }
    }
}
