public class AddDigits {
    public static int solution(int n) {
        return String.valueOf(n).chars()
                .map(c -> Character.getNumericValue(c))
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(solution(1234));
    }
}
