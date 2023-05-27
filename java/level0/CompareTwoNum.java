public class CompareTwoNum {

    public static int solution(int a, int b){
        int ab = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int twoAB = 2 * a * b;

        return twoAB > ab ? twoAB : ab;
    }
    public static void main(String[] args) {
        int a = 2;
        int b = 91;

        System.out.println(solution(a, b));
    }
}
