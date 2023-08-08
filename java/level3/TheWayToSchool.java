public class TheWayToSchool {
    private static int solution(int m, int n, int[][] puddles){
        int[][] count = new int[n][m];
        boolean[][] isPuddle = new boolean[n][m];

        for(int[] puddle : puddles){
            isPuddle[puddle[1] - 1][puddle[0] - 1] = true;
        }

        count[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isPuddle[i][j]) continue;
                if(i > 0 && !isPuddle[i - 1][j]) count[i][j] += count[i - 1][j] % 1000000007;
                if(j > 0 && !isPuddle[i][j - 1]) count[i][j] += count[i][j - 1] % 1000000007;
            }
        }

        return count[n - 1][m - 1] % 1000000007;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(solution(m, n, puddles));
    }
}
