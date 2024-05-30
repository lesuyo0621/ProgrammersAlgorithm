public class NeighborSameColor {
    private static int solution(String[][] board, int h, int w) {
        int count = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        for (int i = 0; i < 4; i++) {
            if(h + dh[i] < 0 || h + dh[i] >= board.length) continue;
            if(w + dw[i] < 0 || w + dw[i] >= board[0].length) continue;
            if(board[h][w].equals(board[h + dh[i]][w + dw[i]])) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        System.out.println(solution(board, 1, 1));
    }
}
