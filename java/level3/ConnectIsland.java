import java.util.*;

public class ConnectIsland {
    private static class Node {
        private int depth = 1;
        private Node parent = null;

        public boolean isConnected(Node n) {
            return root() == n.root();
        }

        public void merge(Node n) {
            Node root1 = root();
            Node root2 = n.root();

            if (root1.depth > root2.depth) {
                root2.parent = root1;
            } else if (root1.depth < root2.depth) {
                root1.parent = root2;
            } else {
                root2.parent = root1;
                root1.depth++;
            }
        }

        private Node root() {
            if (parent == null) return this;
            return parent.root();
        }
    }

    public static int solution(int n, int[][] costs) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int totalCost = 0;
        for (int[] c : costs) {
            Node node1 = nodes[c[0]];
            Node node2 = nodes[c[1]];

            if (node1.isConnected(node2)) continue;
            node1.merge(node2);
            totalCost += c[2];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        System.out.println(solution(4, costs));
    }
}
