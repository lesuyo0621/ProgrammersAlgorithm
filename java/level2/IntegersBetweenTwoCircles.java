public class IntegersBetweenTwoCircles {
    private static long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            long y1 = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));
            long y2 = (long) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2)));

            answer += y2 - y1 + 1;
        }

        return answer * 4;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 3));
    }
}
