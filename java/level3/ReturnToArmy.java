import java.util.*;

public class ReturnToArmy {
    private static Map<Integer, Integer> distanceMap = new HashMap<>();

    private static void setDistance(int n, int e, List<List<Integer>> bridge) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{e, 0});
        visited[e] = true;

        while (!q.isEmpty()) {
            int[] data = q.poll();

            int curr = data[0];
            int count = data[1];
            distanceMap.put(curr, count);

            List<Integer> b = bridge.get(curr);
            for (int next : b) {
                if (visited[next]) continue;

                visited[next] = true;
                q.add(new int[]{next, count + 1});
            }
        }
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> bridge = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            bridge.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            bridge.get(r[0]).add(r[1]);
            bridge.get(r[1]).add(r[0]);
        }

        setDistance(n, destination, bridge);

        int[] answer = new int[sources.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = distanceMap.getOrDefault(sources[i], -1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] roads = {{1, 2}, {2, 3}};
        int[] sources = {2, 3};
        int destination = 1;

        System.out.println(Arrays.toString(solution(n, roads, sources, destination)));
    }
}
