import java.util.Queue;
import java.util.LinkedList;

public class bridgeTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int nextTruck = 0;
        int currentW = 0;

        Queue<Integer> bridge = new LinkedList<Integer>();
        Queue<Integer> inBWeigth = new LinkedList<Integer>();
        Queue<Integer> crossB = new LinkedList<Integer>();

        while (crossB.size() != truck_weights.length) {
            if (currentW < weight && nextTruck < truck_weights.length
                    && currentW + truck_weights[nextTruck] <= weight) {
                if (bridge.size() == 0) {
                    bridge.add(1);
                    inBWeigth.add(truck_weights[nextTruck]);
                    currentW += truck_weights[nextTruck];
                    nextTruck++;
                } else {
                    for (int i = 0; i < inBWeigth.size(); i++) {
                        int time = bridge.poll().intValue();
                        time++;
                        bridge.add(time);
                    }
                    if (bridge.peek() > bridge_length) {
                        int crossTW = inBWeigth.poll();
                        bridge.poll();
                        currentW -= crossTW;
                        crossB.add(crossTW);
                    }
                    bridge.add(1);
                    inBWeigth.add(truck_weights[nextTruck]);
                    currentW += truck_weights[nextTruck];
                    nextTruck++;
                }
                answer++;
            } else {
                for (int i = 0; i < inBWeigth.size(); i++) {
                    int time = bridge.poll().intValue();
                    time++;
                    bridge.add(time);
                }
                if (bridge.peek() > bridge_length) {
                    int crossTW = inBWeigth.poll();
                    bridge.poll();
                    currentW -= crossTW;
                    crossB.add(crossTW);
                    if (currentW < weight && nextTruck < truck_weights.length
                            && currentW + truck_weights[nextTruck] <= weight) {
                        if (bridge.size() == 0) {
                            bridge.add(1);
                            inBWeigth.add(truck_weights[nextTruck]);
                            currentW += truck_weights[nextTruck];
                            nextTruck++;
                        } else {
                            bridge.add(1);
                            inBWeigth.add(truck_weights[nextTruck]);
                            currentW += truck_weights[nextTruck];
                            nextTruck++;
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7, 4, 5, 6 };

        bridgeTruck bt = new bridgeTruck();
        System.out.println(bt.solution(bridge_length, weight, truck_weights));
    }
}