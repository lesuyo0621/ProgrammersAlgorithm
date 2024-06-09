public class NBaseGame {
    private static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int turn = 0;
        int num = 0;

        while (count < t) {
            String numStr = Integer.toString(num, n).toUpperCase();

            for (int i = 0; i < numStr.length(); i++) {
                if (turn % m == p - 1) {
                    sb.append(numStr.charAt(i));
                    count++;

                    if(count >= t) break;
                }

                turn++;
            }

            num++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 2));
    }
}
