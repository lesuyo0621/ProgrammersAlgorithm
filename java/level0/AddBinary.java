public class AddBinary {
    private static String solution(String bin1, String bin2) {
        return Integer.toString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2), 2);
    }

    public static void main(String[] args) {
        System.out.println(solution("10", "11"));
    }
}
