import java.util.Arrays;

public class EmoticonsDiscountEvent {
    private static int maxEmoticonPlusCount = 0;
    private static int totalPrice = 0;

    private static void calc(int[] discount, int[][] users, int[] emoticons) {
        int emoticonPlusCount = 0;
        int price = 0;

        for (int[] user : users) {
            int sum = 0;

            for (int i = 0; i < emoticons.length; i++) {
                int d = 40 - (10 * discount[i]);

                if (d >= user[0]) {
                    sum += ((100 - d) / (double) 100.0) * emoticons[i];
                }
            }

            if (sum >= user[1]) {
                emoticonPlusCount++;
            } else {
                price += sum;
            }
        }

        if (emoticonPlusCount > maxEmoticonPlusCount) {
            maxEmoticonPlusCount = emoticonPlusCount;
            totalPrice = price;
        } else if (emoticonPlusCount == maxEmoticonPlusCount && price > totalPrice) {
            totalPrice = price;
        }
    }

    private static void findMax(int idx, int[] discount, int[][] users, int[] emoticons) {
        if (idx >= discount.length) {
            calc(discount, users, emoticons);
            return;
        }

        for (int i = 0; i < 4; i++) {
            discount[idx] = i;

            findMax(idx + 1, discount, users, emoticons);
        }
    }

    private static int[] solution(int[][] users, int[] emoticons) {
        int n = users.length;
        int m = emoticons.length;

        int[] discount = new int[m];
        findMax(0, discount, users, emoticons);

        return new int[]{maxEmoticonPlusCount, totalPrice};
    }

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        System.out.println(Arrays.toString(solution(users, emoticons)));
    }
}
