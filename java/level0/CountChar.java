public class CountChar {
    private static int[] solution(String my_string) {
        int[] answer = new int[52];

        for (char c : my_string.toCharArray()) {
            if (c - 'A' >= 0 && c - 'A' <= 25) {
                answer[c - 'A']++;
            } else if (c - 'a' >= 0 && c - 'a' <= 25) {
                answer[c - 'a' + 26]++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("Programmers"));
    }
}
