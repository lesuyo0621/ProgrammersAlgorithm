public class IdentifyingSquareNumber {
    private static int solution(int n) {
        for(int i = 0; i <= 1000; i++) {
            if(n == Math.pow(i, 2)) {
                return 1;
            }
        }

        return 2;
    }

    public static void main(String[] args) {
        System.out.println(solution(144));
    }
}
