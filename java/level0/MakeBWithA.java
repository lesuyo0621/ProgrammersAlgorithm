import java.util.HashMap;
import java.util.Map;

public class MakeBWithA {
    private static int solution(String before, String after) {
        Map<Character, Integer> mapB = new HashMap<>();
        Map<Character, Integer> mapA = new HashMap<>();

        for (char c : before.toCharArray()) {
            mapB.put(c, mapB.getOrDefault(c, 0) + 1);
        }

        for (char c : after.toCharArray()) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }

        return mapB.equals(mapA) ? 1 : 0;
    }


    public static void main(String[] args) {
        System.out.println(solution("olleh", "hello"));
    }
}
