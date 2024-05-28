import java.util.Arrays;

public class CountBetweenX {
    private static int[] solution(String myString) {
        return Arrays.stream(myString.split("x", myString.length()))
                .mapToInt(s -> s.length())
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(solution("oxooxoxxox"));
    }
}
