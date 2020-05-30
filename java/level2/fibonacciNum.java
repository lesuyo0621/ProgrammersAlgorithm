import java.math.BigInteger;

public class fibonacciNum {

    // first answer..
    // 재귀로 풀어버리니 메모리가 상당히 커짐..
    BigInteger[] num = new BigInteger[100001];

    public int solution(int n) {
        num[0] = BigInteger.valueOf(0);
        num[1] = BigInteger.valueOf(1);

        BigInteger answer = pb(n).mod(BigInteger.valueOf(1234567));
        System.out.print(answer);

        return answer.intValue();
    }

    public BigInteger pb(int target) {
        if (num[target] != null)
            return num[target];
        return num[target] = pb(target - 1).add(pb(target - 2));
    }

    // second answer..
    public int solution2(int n) {
        int answer = 0;

        int num0 = 0;
        int num1 = 1;
        int pNum = num0 + num1;
        int mod = 1234567;

        // 나머지를 더해도 결국 답은 같다는 걸 나중에 깨달음..
        // EX) (123 % 10) + (129 % 10) = 12 -> 12 % 10 = 2.. 결국 원하는 값은 도출됨..
        for (int i = 3; i <= n; i++) {
            num0 = num1 % mod;
            num1 = pNum % mod;
            pNum = (num0 + num1) % mod;
        }

        answer = pNum;

        return answer;
    }

    public static void main(String[] args) {

        fibonacciNum fb = new fibonacciNum();
        System.out.println(fb.solution(50));
    }
}