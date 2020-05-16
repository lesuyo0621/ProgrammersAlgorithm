public class gcdLcm {
    public int[] solution(int n, int m) {

        int min = Math.min(n, m);
        int max = Math.max(n, m);
        int etc = max % min;

        while (etc != 0) {
            max = min;
            min = etc;
            etc = max % min;
        }

        int[] answer = { min, n * m / min };

        return answer;
    }
}