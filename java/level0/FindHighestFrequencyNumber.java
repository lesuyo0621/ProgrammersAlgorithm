import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindHighestFrequencyNumber {
    private static int solution(int[] array){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < array.length; i++){
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        Integer max = Collections.max(map.values());
        List<Integer> keyList = map.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        return keyList.size() > 1 ? -1 : keyList.get(0);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 3, 3, 4}));
    }
}
