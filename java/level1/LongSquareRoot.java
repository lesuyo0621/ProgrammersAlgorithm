public class LongSquareRoot {

    public long solution(long n) {
        long num = (long) Math.sqrt(n);
        if (num * num == n)
            return (num + 1) * (num + 1);
        return -1;
    }

    public static void main(String[] args) {
        long n = 121;

        LongSquareRoot lsr = new LongSquareRoot();
        System.out.println(lsr.solution(n));
    }
}