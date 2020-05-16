public class longSquareRoot {

    public long solution(long n) {
        long num = (long) Math.sqrt(n);
        if (num * num == n)
            return (num + 1) * (num + 1);
        return -1;
    }

    public static void main(String[] args) {
        long n = 121;

        longSquareRoot lsr = new longSquareRoot();
        System.out.println(lsr.solution(n));
    }
}