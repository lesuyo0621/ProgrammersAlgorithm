public class MagicElevator {
    private static int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int remainder = storey % 10;
            storey /= 10;

            if (remainder < 5) {
                answer += remainder;
            } else if (remainder == 5) {
                if (storey % 10 < 5 || storey % 100 == 0) {
                    answer += remainder;
                } else {
                    answer += 10 - remainder;
                    storey++;
                }
            } else {
                answer += 10 - remainder;
                storey++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(16));
    }
}
