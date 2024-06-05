public class AdditionOfHiddenNumber2 {
    private static int solution(String my_string) {
        int answer = 0;
        String[] numStrArr = my_string.split("[^0-9]");

        for (String n : numStrArr) {
            if (n.length() == 0) continue;

            answer += Integer.parseInt(n);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aAb1B2cC34oOp"));
    }
}
