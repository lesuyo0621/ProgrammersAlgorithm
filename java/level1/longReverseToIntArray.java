import java.util.Arrays;

public class longReverseToIntArray {

    public int[] solution(long n) {

        String s = Long.toString(n);
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            answer[i] = s.charAt(s.length() - i - 1) - 48;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 12345;

        longReverseToIntArray ltoi = new longReverseToIntArray();
        System.out.println(Arrays.toString(ltoi.solution(n)));
    }
}