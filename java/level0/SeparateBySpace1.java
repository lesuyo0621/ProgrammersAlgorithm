import java.util.Arrays;

public class SeparateBySpace1 {
    private static String[] solution(String my_string) {
        return my_string.split(" ");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("i love you")));
    }
}
