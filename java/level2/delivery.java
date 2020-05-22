public class delivery {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distance = new int[N + 1];
        boolean[] check = new boolean[N + 1];
        int[][] map = new int[N + 1][N + 1];

        // 마을 거리 최소 도로로 세팅
        // 먼저 최댓값으로 초기화시키고
        for (int t = 0; t < map.length; t++) {
            for (int q = 0; q < map[0].length; q++) {
                if (t != q) {
                    map[t][q] = 5000001;
                }
            }
        }
        // 그 후 최소값으로 세팅
        for (int p = 0; p < road.length; p++) {
            if (map[road[p][0]][road[p][1]] > road[p][2] || map[road[p][1]][road[p][0]] > road[p][2]) {
                map[road[p][0]][road[p][1]] = road[p][2];
                map[road[p][1]][road[p][0]] = road[p][2];
            }
        }

        // 시작지점부터 i지점까지의 걸리는 거리 최대로 설정
        for (int i = 1; i < N + 1; i++) {
            distance[i] = 5000001;
        }

        // 시작점은 자기 자신과의 거리니 0
        // 자기 자신은 들린 지점이니 트루체크
        distance[1] = 0;
        check[1] = true;

        // 시작점과 연결노드 distance갱신
        // 연결 안된 곳은 위에서 5000001 최댓값으로 세팅했
        for (int j = 1; j < N + 1; j++) {
            if (!check[j] && map[1][j] != 0 && map[1][j] != 5000001) {
                distance[j] = map[1][j];
            }
        }

        for (int i = 0; i < N - 1; i++) {

            int min = 5000001;
            int min_index = -1;

            // 최솟값 찾기
            for (int j = 1; j < N + 1; j++) {
                if (!check[j] && distance[j] != 5000001) {
                    if (distance[j] < min) {
                        min = distance[j];
                        min_index = j;
                    }
                }
            }

            check[min_index] = true;

            for (int j = 1; j < N + 1; j++) {
                if (!check[j] && map[min_index][j] != 0) {
                    if (distance[j] > distance[min_index] + map[min_index][j]) {
                        distance[j] = distance[min_index] + map[min_index][j];
                    }
                }
            }
        }

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
        int K = 3;

        delivery d = new delivery();
        System.out.println(d.solution(N, road, K));
    }
}