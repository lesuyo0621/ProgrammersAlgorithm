public class PrintEvenOdd {
    public static void main(String[] args) {
        int n = 100;
        String result = n % 2 == 0 ? "is even" : "is odd";

        System.out.print(n + " " + result);
    }
}
