public class AdditionOfHiddenNumber {
    public static int solution(String my_string) {
        return my_string.chars()
                .filter(c -> 48 < c && c < 58)
                .map(c -> c - 48)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(solution("1a2b3c4d123"));
    }
}
