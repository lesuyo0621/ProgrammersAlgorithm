import java.util.Arrays;

public class RemoveLetter {
    private static String solution(String my_string, int[] indices) {
        String answer = "";
        Arrays.sort(indices);

        int j = 0;
        for (int i = 0; i < my_string.length(); i++) {
            if (j < indices.length && i == indices[j]) {
                j++;
            } else {
                answer += my_string.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("apporoograpemmemprs", new int[]{1, 16, 6, 15, 0, 10, 11, 3}));
    }
}
