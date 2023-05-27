import java.util.stream.IntStream;

public class ShuffleString {
    public static String solution(String str1, String str2){
        return IntStream.range(0, str1.length())
                .mapToObj(i -> "" + str1.charAt(i) + str2.charAt(i))
                .reduce((x, y) -> x + y)
                .orElse("");
    }

    public static void main(String[] args) {
        String str1 = "aaaaa";
        String str2 = "bbbbb";

        System.out.println(solution(str1, str2));
    }
}
