public class NewIDRecommendation {
    private static String solution(String new_id) {
        String answer = "";

        // 1
        answer = new_id.toLowerCase();

        // 2
        answer = answer.replaceAll("[^a-z0-9\\-\\_\\.]", "");

        // 3
        answer = answer.replaceAll("[.]+", ".");

        // 4
        if (answer.startsWith(".")) {
            answer = answer.substring(1, answer.length());
        }

        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5
        if (answer.length() == 0) {
            answer = "a";
        }

        // 6
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);

            if (answer.endsWith(".")) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 7
        if (answer.length() <= 2) {
            answer += answer.substring(answer.length() - 1, answer.length()).repeat(3 - answer.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
