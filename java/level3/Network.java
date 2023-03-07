public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] check = new int[n];

        for (int i = 0; i < check.length; i++) {
            if (check[i] == 0) {
                find(i, computers, check);
                answer++;
            }
        }

        return answer;
    }

    public void find(int nodeNum, int[][] computers, int[] check) {

        check[nodeNum] = 1;
        for (int j = 0; j < computers[nodeNum].length; j++) {
            if (computers[nodeNum][j] == 1 && check[j] == 0) {
                find(j, computers, check);
            }
        }
        return;
    }

    public static void main(String[] args) {

        int n = 3;
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        Network nt = new Network();
        System.out.println(nt.solution(n, computers));
    }
}