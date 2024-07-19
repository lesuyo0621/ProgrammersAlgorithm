import java.util.*;

public class PathFindingGame {
    static class Node {
        int num;
        int x;
        int y;
        Node left;
        Node right;

        Node (int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    private static void makeTree(Node root, Node child) {
        if (child.x < root.x) {
            if (root.left == null) {
                root.left = child;
            } else {
                makeTree(root.left, child);
            }
        } else {
            if (root.right == null) {
                root.right = child;
            } else {
                makeTree(root.right, child);
            }
        }
    }

    private static void getPreorder(Node root, List<Integer> list) {
        if (root == null) return;

        list.add(root.num);
        getPreorder(root.left, list);
        getPreorder(root.right, list);
    }

    private static void getPostorder(Node root, List<Integer> list) {
        if (root == null) return;

        getPostorder(root.left, list);
        getPostorder(root.right, list);
        list.add(root.num);
    }

    public static int[][] solution(int[][] nodeinfo) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> b.y - a.y
        );

        for (int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];

            pq.add(new Node(i + 1, x, y));
        }

        Node root = pq.poll();
        while (!pq.isEmpty()) {
            makeTree(root, pq.poll());
        }

        List<Integer> preorder = new ArrayList<>();
        getPreorder(root, preorder);
        List<Integer> postorder = new ArrayList<>();
        getPostorder(root, postorder);

        return new int[][]{
                preorder.stream().mapToInt(i -> i).toArray(),
                postorder.stream().mapToInt(i -> i).toArray()
        };
    }

    public static void main(String[] args) {
        int[][] answer = solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});

        for (int[] a : answer) {
            System.out.println(Arrays.toString(a));
        }
    }
}
