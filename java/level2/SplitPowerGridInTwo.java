import java.util.*;

public class SplitPowerGridInTwo {
    private static int getCount(int root, List<Integer>[] nodeList, boolean[] visited, int count) {
        visited[root] = true;

        List<Integer> connectNodeList = nodeList[root];
        for (int i = 0; i < connectNodeList.size(); i++) {
            int next = connectNodeList.get(i);

            if (!visited[next]) {
                count = getCount(next, nodeList, visited, ++count);
            }
        }

        return count;
    }

    public static int solution(int n, int[][] wires) {
        List<Integer>[] nodeList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int[] w : wires) {
            nodeList[w[0]].add(w[1]);
            nodeList[w[1]].add(w[0]);
        }

        int min = Integer.MAX_VALUE;
        for (int[] w : wires) {
            boolean[] visited = new boolean[n + 1];
            visited[w[0]] = true;
            visited[w[1]] = true;

            int left = getCount(w[0], nodeList, visited, 1);
            int right = getCount(w[1], nodeList, visited, 1);

            if (Math.abs(left - right) < min) {
                min = Math.abs(left - right);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }
}
