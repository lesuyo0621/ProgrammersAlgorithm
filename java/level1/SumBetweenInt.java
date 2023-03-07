public class SumBetweenInt {

    // My first answer..
    public long solution(int a, int b) {
        long answer = 0;
        int temp = 0;

        // a 작은 수 b 큰 수

        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        } else if (a == b) {
            return a;
        }

        long num1 = a;
        long num2 = b;

        if (a * b >= 0) {
            answer = (num2 * (num2 + 1)) / 2 - ((num1 - 1) * num1) / 2;
        } else {
            num1 = -num1;
            answer = (num2 * (num2 + 1)) / 2 - (num1 * (num1 + 1)) / 2;
        }

        return answer;
    }

    // I think the best
    public long solution2(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        SumBetweenInt sb = new SumBetweenInt();
        System.out.println(sb.solution2(a, b));
    }
}