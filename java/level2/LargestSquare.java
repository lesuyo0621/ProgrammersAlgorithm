public class LargestSquare {
    private static boolean allZero(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) return false;
            }
        }

        return true;
    }

    private static int solution(int[][] board) {
        if (allZero(board)) return 0;

        int max = 1;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;

                    max = Math.max(max, board[i][j]);
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
    }
}
