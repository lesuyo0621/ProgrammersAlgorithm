public class LongestPalindrome {
    private static String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");

        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }

        return sb.toString();
    }

    private static int solution(String s) {
        char[] chars = preprocess(s).toCharArray();
        int[] P = new int[chars.length];
        int center = 0, right = 0;

        for (int i = 0; i < P.length; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                P[i] = Math.min(right - i, P[mirror]);
            }

            int l = i - (P[i] + 1);
            int r = i + (P[i] + 1);
            while (l >= 0 && r < P.length && chars[l] == chars[r]) {
                P[i]++;
                l--;
                r++;
            }

            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        int max = 0;
        for (int p : P) {
            max = Math.max(max, p);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdcba"));
    }
}
