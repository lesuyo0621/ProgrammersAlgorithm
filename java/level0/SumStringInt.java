public class SumStringInt {
    private static int solution(String num_str) {
        return num_str.chars()
                .map(c -> Character.getNumericValue(c))
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(solution("123456789"));
    }
}
