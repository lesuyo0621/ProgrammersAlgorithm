import java.util.Arrays;

public class NNumsSpacedByX {

    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;

        for (int i = 0; i < n; i++) {
            answer[i] = num + (i * num);
        }

        return answer;
    }

    public static void main(String[] args) {

        int x = 2;
        int n = 5;

        NNumsSpacedByX ns = new NNumsSpacedByX();
        System.out.println(Arrays.toString(ns.solution(x, n)));
    }
}