import java.util.Arrays;

public class MatrixMultiplication {
    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0; i < arr1.length; i ++){
            for(int j = 0; j < arr2[0].length; j++){
                for(int k = 0; k < arr2.length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
//        int[][] arr2 = {{3, 3}, {3, 3}};

//        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
//        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

//        int[][] arr1 = {{3, 3, 3}, {3, 3, 3}};
//        int[][] arr2 = {{1, 4}, {3, 2}, {4, 1}};

        int[][] arr1 = {{1, 2}, {3, 4}};
        int[][] arr2 = {{5, 6, 7}, {8, 9, 10}};

        System.out.println(Arrays.toString(solution(arr1, arr2)));
    }
}
