import java.util.*;

public class TowerOfHanoi {
    private static void hanoi(int n, int from, int to, List<int[]> list) {
        if (n == 1) {
            list.add(new int[]{from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi(n - 1, from, empty, list);
        hanoi(1, from, to, list);
        hanoi(n - 1, empty, to, list);
    }

    private static int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
        hanoi(n, 1, 3, list);

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] answer = solution(5);

        for (int[] a : answer) {
            System.out.println(Arrays.toString(a));
        }
    }
}
