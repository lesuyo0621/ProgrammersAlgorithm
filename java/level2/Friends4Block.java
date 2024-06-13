public class Friends4Block {
    private static int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean[][] mark = new boolean[board.length][board[0].length()];

        boolean find = true;
        while (find) {
            find = false;

            for (int v = 0; v < board.length - 1; v++) {
                for (int h = 0; h < board[0].length() - 1; h++) {
                    String s1 = board[v];
                    String s2 = board[v + 1];

                    char c1 = s1.charAt(h);
                    char c2 = s1.charAt(h + 1);
                    char c3 = s2.charAt(h);
                    char c4 = s2.charAt(h + 1);

                    if (c1 == 'x' || c2 == 'x' || c3 == 'x' || c4 == 'x') continue;

                    if (c1 == c2 && c2 == c3 && c3 == c4 && c4 == c1) {
                        mark[v][h] = true;
                        mark[v][h + 1] = true;
                        mark[v + 1][h] = true;
                        mark[v + 1][h + 1] = true;

                        find = true;
                    }
                }
            }

            if (find) {
                for (int i = 0; i < mark.length; i++) {
                    for (int j = 0; j < mark[0].length; j++) {
                        if (mark[i][j]) {
                            for (int v = i; v >= 0; v--) {
                                char[] origin = board[v].toCharArray();

                                if (v <= 0) {
                                    origin[j] = 'x';
                                } else {
                                    char[] upstair = board[v - 1].toCharArray();
                                    origin[j] = upstair[j];
                                }

                                board[v] = new String(origin);
                            }

                            answer++;
                            mark[i][j] = false;
                        }
                    }
                }
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }
}
