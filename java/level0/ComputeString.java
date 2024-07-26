public class ComputeString {
    private static int solution(String my_string) {
        String[] s = my_string.split(" ");

        int answer = Integer.parseInt(s[0]);
        int idx = 2;
        while (idx < s.length) {
            int next = Integer.parseInt(s[idx]);

            switch (s[idx - 1]) {
                case "+" -> answer = answer + next;
                case "-" -> answer = answer - next;
                default -> answer = answer;
            }

            idx += 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("3 + 4"));
    }
}
