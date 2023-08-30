import java.util.stream.IntStream;

public class JSmallSubstring {
    private static int solution(String t, String p) {
        return (int) IntStream.rangeClosed(0, t.length() - p.length())
                .mapToObj(i -> Long.parseLong(t.substring(i, i + p.length())))
                .filter(num -> Long.parseLong(p) >= num)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));
    }
}
