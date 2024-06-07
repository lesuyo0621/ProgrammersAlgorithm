import java.util.HashMap;
import java.util.Map;

public class MostReceivedGift {
    private static int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> give = new HashMap<>();
        Map<String, Integer> giveCount = new HashMap<>();
        Map<String, Integer> receiveCount = new HashMap<>();
        Map<String, Integer> nextReceiveCount = new HashMap<>();

        for (String f : friends) {
            give.put(f, new HashMap<>());
            giveCount.put(f, 0);
            receiveCount.put(f, 0);
            nextReceiveCount.put(f, 0);
        }

        for (String gift : gifts) {
            String[] g = gift.split(" ");
            String giver = g[0];
            String receiver = g[1];

            Map<String, Integer> rMap = give.get(giver);
            rMap.put(receiver, rMap.getOrDefault(receiver, 0) + 1);
            give.put(giver, rMap);

            giveCount.put(giver, giveCount.get(giver) + 1);
            receiveCount.put(receiver, receiveCount.get(receiver) + 1);
        }

        for (String me : friends) {
            int meGiftRatio = giveCount.get(me) - receiveCount.get(me);

            for (String you : friends) {
                if (you.equals(me)) continue;

                int meGiftCount = give.get(me).getOrDefault(you, 0);
                int youGiftCount = give.get(you).getOrDefault(me, 0);
                int youGiftRatio = giveCount.get(you) - receiveCount.get(you);

                if (meGiftCount > youGiftCount) {
                    nextReceiveCount.put(me, nextReceiveCount.get(me) + 1);
                } else if (youGiftCount > meGiftCount) {
                    nextReceiveCount.put(you, nextReceiveCount.get(you) + 1);
                } else if (meGiftRatio > youGiftRatio) {
                    nextReceiveCount.put(me, nextReceiveCount.get(me) + 1);
                } else if (youGiftRatio > meGiftRatio) {
                    nextReceiveCount.put(you, nextReceiveCount.get(you) + 1);
                }
            }
        }

        int max = 0;
        for (String f : nextReceiveCount.keySet()) {
            int count = nextReceiveCount.get(f);

            if (max < count) max = count;
        }

        return max / 2;
    }

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        System.out.println(solution(friends, gifts));
    }
}
