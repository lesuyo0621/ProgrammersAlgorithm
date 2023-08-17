import java.util.*;

public class FurthestNode {
    static class Node{
        int index;
        Set<Integer> nextNodes = new HashSet<>();

        Node(int index){
            this.index = index;
        }
    }

    private static int solution(int n, int[][] edge) {
        Node[] nodes = new Node[n + 1];

        for(int i = 1; i <= n; i++){
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < edge.length; i++){
            int node1 = edge[i][0];
            int node2 = edge[i][1];

            nodes[node1].nextNodes.add(node2);
            nodes[node2].nextNodes.add(node1);
        }

        int distance = 1;
        int[] map = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        Queue<Integer> next = new LinkedList<>();
        next.add(1);
        check[1] = true;

        while(next.size() > 0){
            int size = next.size();

            for(int i = 0; i < size; i++){
                int j = next.poll();

                Node node = nodes[j];
                map[node.index] = distance;

                for(int nextNode : node.nextNodes){
                    if(!check[nextNode]){
                        next.add(nextNode);
                        check[nextNode] = true;
                    }
                }
            }

            distance++;
        }

        final int lastDistance = distance - 1;
        return (int) Arrays.stream(map).filter(num -> num == lastDistance).count();
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution(n, vertex));
    }
}
