public class kakaoCrane {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] bucket = new int[moves.length];
        int peek = -1;
        int bucketnum = 0;
        int boardnum = 0;
        int flag = 0;

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    peek = board[j][moves[i] - 1];
                    boardnum = j;
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                flag = 0;
                board[boardnum][moves[i] - 1] = 0;
                if (bucketnum > 0) {
                    if (bucket[bucketnum - 1] == peek) {
                        answer++;
                        bucket[bucketnum - 1] = 0;
                        bucketnum--;
                    } else {
                        bucket[bucketnum] = peek;
                        bucketnum++;
                    }
                } else {
                    bucket[bucketnum] = peek;
                    bucketnum++;
                }
            } else {
                continue;
            }
        }
        return answer * 2;
    }

    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

        kakaoCrane kc = new kakaoCrane();
        System.out.println(kc.solution(board, moves));
    }
}