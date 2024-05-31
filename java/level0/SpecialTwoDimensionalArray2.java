public class SpecialTwoDimensionalArray2 {
    private static int solution(int[][] arr) {
        boolean fail = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] != arr[j][i]) fail = true;
            }
        }

        return fail ? 0 : 1;
    }

    public static void main(String[] args) {
        int[][] arr = {{5, 192, 33}, {192, 77, 95}, {33, 95, 999}};
        System.out.println(solution(arr));
    }
}
