import java.util.Arrays;

public class Land {
    private static int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];

        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(j == k) continue;

                    int max = dp[i][j];
                    int calc = land[i][j] + dp[i - 1][k];

                    if(calc > max) dp[i][j] = calc;
                }
            }
        }

        return Arrays.stream(dp[dp.length - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        System.out.println(solution(land));
    }
}
