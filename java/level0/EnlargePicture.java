import java.util.Arrays;

public class EnlargePicture {
    private static String[] solution(String[] picture, int k) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (String p : picture) {
            for (int i = 0; i < p.length(); i++) {
                for (int j = 0; j < k; j++) {
                    sb.append(p.charAt(i));
                }
            }

            for (int i = 0; i < k; i++) {
                answer.append(sb.toString());
                answer.append(":");
            }

            sb.setLength(0);
        }

        return answer.toString().split(":");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"x.x", ".x.", "x.x"}, 3)));
    }
}
