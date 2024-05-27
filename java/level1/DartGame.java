public class DartGame {
    private static int solution(String dartResult) {
        int[] score = new int[3];
        int sum = 0;

        int scoreIndex = 0;
        int numberIndex = 0;
        for(int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c == 'S' || c == 'D' || c == 'T') {
                score[scoreIndex] = Integer.parseInt(dartResult.substring(numberIndex, i));

                if (c == 'D') score[scoreIndex] = (int) Math.pow(score[scoreIndex], 2);
                else if (c == 'T') score[scoreIndex] = (int) Math.pow(score[scoreIndex], 3);

                scoreIndex++;
                numberIndex = i + 1;
            } else if (c == '*') {
                for (int j = scoreIndex - 1; j > -1 && j >= scoreIndex - 2; j--) {
                    score[j] *= 2;
                }
                numberIndex = i + 1;
            } else if (c == '#') {
                score[scoreIndex - 1] *= -1;
                numberIndex = i + 1;
            }
        }

        for(int s : score) {
            sum += s;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }
}
