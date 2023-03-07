import java.util.Arrays;

public class CustomStringSort {
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.stream(strings)
                .sorted((a, b) -> a.charAt(n) == b.charAt(n) ? a.compareTo(b) : a.charAt(n) - b.charAt(n))
                .toArray(String[]::new);

        return answer;
    }

    public static void main(String[] args) {

        String[] strings = { "abce", "abcd", "cdx" };
        int n = 2;

        CustomStringSort cs = new CustomStringSort();
        System.out.println(Arrays.toString(cs.solution(strings, n)));
    }
}