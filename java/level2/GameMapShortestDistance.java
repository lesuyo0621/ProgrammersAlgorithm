import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
    private static int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        maps[0][0]++;

        int answer = 0;
        int size = queue.size();
        while(size > 0){
            answer++;

            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();

                int x = pos[1];
                int y = pos[0];

                if(x == maps[0].length - 1 && y == maps.length - 1) return answer;

                // down
                if(y + 1 < maps.length && maps[y + 1][x] == 1){
                    maps[y + 1][x]++;
                    queue.add(new int[]{y + 1, x});
                }

                // right
                if(x + 1 < maps[0].length && maps[y][x + 1] == 1){
                    maps[y][x + 1]++;
                    queue.add(new int[]{y, x + 1});
                }

                // up
                if(x - 1 >= 0 && maps[y][x - 1] == 1){
                    maps[y][x - 1]++;
                    queue.add(new int[]{y, x - 1});
                }

                // left
                if(y - 1 >= 0 && maps[y - 1][x] == 1){
                    maps[y - 1][x]++;
                    queue.add(new int[]{y - 1, x});
                }
            }

            size = queue.size();
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}}));
    }
}
