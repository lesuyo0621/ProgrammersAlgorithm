public class RemainderAfterDividingBy9 {
    private static int solution(String number) {
        return (number.chars().reduce(0, (total, num) -> total + (num - 48))) % 9;
    }

    public static void main(String[] args) {
        System.out.println(solution("78720646226947352489"));
    }
}
