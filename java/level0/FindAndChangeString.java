import java.util.stream.Collectors;

public class FindAndChangeString {
    private static int solution(String myString, String pat) {
        return myString.indexOf(pat.chars().mapToObj(c -> c == 'A' ? "B" : "A").collect(Collectors.joining())) > -1 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABBAA", "AABB"));
    }
}
