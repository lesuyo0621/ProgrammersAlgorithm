import java.util.Arrays;

public class customStringSort {
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.stream(strings)
                .sorted((a, b) -> a.charAt(n) == b.charAt(n) ? a.compareTo(b) : a.charAt(n) - b.charAt(n))
                .toArray(String[]::new);

        return answer;
    }

    public static void main(String[] args) {

        String[] strings = { "abce", "abcd", "cdx" };
        int n = 2;

        customStringSort cs = new customStringSort();
        System.out.println(Arrays.toString(cs.solution(strings, n)));
    }
}