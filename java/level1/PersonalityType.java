public class PersonalityType {
    private static String solution(String[] survey, int[] choices) {
        int[] score = new int[128];
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i] - 4;
            String s = survey[i];

            if (choice < 0) {
                score[s.charAt(0)] += Math.abs(choice);
            } else if (choice > 0) {
                score[s.charAt(1)] += choice;
            }
        }

        String answer = "";
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

        for (char[] t : types) {
            if (score[t[0]] < score[t[1]]) {
                answer += t[1];
            } else {
                answer += t[0];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }
}
