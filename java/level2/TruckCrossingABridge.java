import java.util.*;

public class TruckCrossingABridge {
    static class Truck {
        public final int w;
        public int t = 0;

        Truck(int w) {
            this.w = w;
        }
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waits = new LinkedList<>();
        Queue<Truck> onBridge = new LinkedList<>();

        for (int w : truck_weights) {
            waits.add(new Truck(w));
        }

        int time = 1;
        Truck truck = waits.poll();
        truck.t++;
        weight -= truck.w;
        onBridge.add(truck);
        while (!onBridge.isEmpty() || !waits.isEmpty()) {
            for (Truck t : onBridge) {
                t.t++;
            }

            if (onBridge.peek().t > bridge_length) {
                Truck t = onBridge.poll();
                weight += t.w;
            }

            if (!waits.isEmpty()) {
                Truck wt = waits.peek();

                if (weight >= wt.w) {
                    onBridge.add(waits.poll());
                    weight -= wt.w;
                    wt.t++;
                }
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
    }
}
