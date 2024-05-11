import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Decryption {
    public static String solution(String cipher, int code) {
        return IntStream.rangeClosed(1, cipher.length() / code)
                .mapToObj(i -> String.valueOf(cipher.charAt(code * i - 1)))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(solution("dfjardstddetckdaccccdegk", 4));
    }
}
