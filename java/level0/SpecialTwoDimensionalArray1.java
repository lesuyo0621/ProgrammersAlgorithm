public class SpecialTwoDimensionalArray1 {
    private static int[][] solution(int n) {
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) arr[i][j] = 1;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
