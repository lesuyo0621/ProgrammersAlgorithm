import java.util.*;

public class TicTacToe {
    private static final int[][] bingo = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}, // 가로
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8}, // 세로
            {0, 4, 8},
            {2, 4, 6} // 대각선
    };

    private static int answer = 0;

    private static char getMark(String[] board, int pos) {
        return board[pos / 3].charAt(pos % 3);
    }

    private static List<Integer> getNext(String[] board, boolean[] used, boolean circle) {
        List<Integer> next = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            if (!used[i]) {
                char m = getMark(board, i);

                if ((circle && m == 'O') || (!circle && m == 'X')) {
                    next.add(i);
                }
            }
        }

        return next;
    }

    private static boolean isBingo(String[] board, boolean[] used) {
        for (int[] b : bingo) {
            if (!used[b[0]] || !used[b[1]] || !used[b[2]]) continue;

            char c1 = getMark(board, b[0]);
            char c2 = getMark(board, b[1]);
            char c3 = getMark(board, b[2]);

            if (c1 == c2 && c2 == c3) return true;
        }

        return false;
    }

    private static void dfs(int depth, int count, String[] board, boolean[] used, boolean circle) {
        if (isBingo(board, used) && depth != count) return;

        if (depth == count) {
            answer = 1;
            return;
        }

        List<Integer> next = getNext(board, used, circle);

        for (int i = 0; i < next.size(); i++) {
            int idx = next.get(i);

            used[idx] = true;
            dfs(depth + 1, count, board, used, !circle);
            used[idx] = false;
        }
    }

    private static int solution(String[] board) {
        int count = 0;
        for (String b : board) {
            for (char c : b.toCharArray()) {
                if (c != '.') count++;
            }
        }

        boolean[] used = new boolean[9];
        dfs(0, count, board, used, true);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"O.X", ".O.", "..X"}));
    }
}
