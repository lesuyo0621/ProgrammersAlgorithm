import java.util.*;

public class TravelRoute {
    private static final List<String> ROUTES = new ArrayList<>();

    private static void dfs(int count, String start, String route, String[][] tickets, boolean[] used) {
        if (count == used.length) {
            ROUTES.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] t = tickets[i];

            if (used[i] || !start.equals(t[0])) continue;

            used[i] = true;
            dfs(count + 1, t[1], route + " " + t[1], tickets, used);
            used[i] = false;
        }
    }

    private static String[] solution(String[][] tickets) {
        boolean[] used = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets, used);

        Collections.sort(ROUTES);

        return ROUTES.get(0).split(" ");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
    }
}
