public class CompareNumbers {

    private static int solution(int num1, int num2){
        return num1 == num2 ? 1 : -1;
    }

    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 3;

        System.out.println(solution(num1, num2));
    }
}
