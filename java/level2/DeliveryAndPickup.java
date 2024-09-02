public class DeliveryAndPickup {
    private static void decreaseBox(int cap, int idx, int[] homes) {
        int count = 0;

        while (count < cap && idx > -1) {
            for (int j = homes[idx]; j > 0; j--) {
                count++;
                homes[idx]--;

                if (count >= cap) break;
            }

            idx--;
        }
    }

    private static int getNextIdx(int idx, int[] homes) {
        while (idx > -1) {
            if (homes[idx] > 0) break;

            idx--;
        }

        return idx;
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int dMax = -1;
        int pMax = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (dMax == - 1 && deliveries[i] != 0) {
                dMax = i;
            }

            if (pMax == -1 && pickups[i] != 0) {
                pMax = i;
            }

            if (dMax != -1 && pMax != -1) break;
        }

        long total = 0;
        while (dMax > -1 || pMax > -1) {
            int distance = Math.max(dMax, pMax) + 1;

            decreaseBox(cap, dMax, deliveries);
            dMax = getNextIdx(dMax, deliveries);

            decreaseBox(cap, pMax, pickups);
            pMax = getNextIdx(pMax, pickups);

            total += (long) distance * 2;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        System.out.println(solution(4, 5, deliveries, pickups));
    }
}
