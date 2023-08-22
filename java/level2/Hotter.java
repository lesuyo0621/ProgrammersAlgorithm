import java.util.PriorityQueue;

public class Hotter {
    private static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> scovQ = new PriorityQueue<>();
        for(int s : scoville){
            scovQ.add(s);
        }

        while(scovQ.size() > 1){
            if(scovQ.peek() >= K) break;

            int scov1 = scovQ.poll();
            int scov2 = scovQ.poll();

            int newScov = scov1 + (scov2 * 2);

            scovQ.add(newScov);
            answer++;
        }

        if(scovQ.peek() < K) return -1;
        return answer;
    }
    
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(scoville, 7));
    }
}
