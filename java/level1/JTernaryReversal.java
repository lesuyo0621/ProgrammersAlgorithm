import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JTernaryReversal {
    private static int solution(int n) {
        String num3 = Integer.toString(n, 3);
        String reverseNum3 = IntStream.rangeClosed(1, num3.length())
                .mapToObj(i -> String.valueOf(num3.charAt(num3.length() - i)))
                .collect(Collectors.joining());

        return Integer.parseInt(reverseNum3, 3);
    }

    public static void main(String[] args) {
        System.out.println(solution(45));
    }
}
