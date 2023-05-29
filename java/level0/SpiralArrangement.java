import java.util.Arrays;

public class SpiralArrangement {
    public static int[][] solution(int n){
        int[][] answer = new int[n][n];
        String direction = "right";
        int row = 0;
        int col = 0;

        for(int i = 0; i < n * n; i++){
            answer[row][col] = i + 1;

            switch(direction){
                case "left":
                    col--;
                    if(col < 0 || answer[row][col] != 0){
                        direction = "up";
                        col++;
                        row--;
                    }
                    break;
                case "right":
                    col++;
                    if(col >= n || answer[row][col] != 0){
                        direction = "down";
                        col--;
                        row++;
                    }
                    break;
                case "up":
                    row--;
                    if(row < 0 || answer[row][col] != 0){
                        direction = "right";
                        col++;
                        row++;
                    }
                    break;
                case "down":
                    row++;
                    if(row >= n || answer[row][col] != 0){
                        direction = "left";
                        col--;
                        row--;
                    }
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Arrays.stream(solution(4)).forEach(a -> System.out.println(Arrays.toString(a)));
    }
}