import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharacter {
    private static String solution(String my_string) {
        Set<Character> set = new HashSet<>();

        String answer = "";
        for (char c : my_string.toCharArray()) {
            if (!set.contains(c)) {
                answer += c;
                set.add(c);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("people"));
    }
}
