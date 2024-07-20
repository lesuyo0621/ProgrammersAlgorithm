import java.util.*;

public class JewelryShopping {
    private static int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gemSet = new HashSet<>();
        for (String g : gems) {
            gemSet.add(g);
        }

        Map<String, Integer> gemCount = new HashMap<>();
        int left = 0;
        int right = 0;
        int distance = Integer.MAX_VALUE;
        while (left < gems.length && right < gems.length) {
            String gem = gems[right];

            gemCount.putIfAbsent(gem, 0);
            gemCount.put(gem, gemCount.get(gem) + 1);

            if (gemCount.keySet().size() == gemSet.size()) {
                while (gemCount.keySet().size() == gemSet.size()) {
                    gem = gems[left];

                    int count = gemCount.get(gem);
                    count--;

                    if (count == 0) {
                        gemCount.remove(gem);
                    } else {
                        gemCount.put(gem, count);
                    }

                    left++;
                }

                if (distance > right - left) {
                    answer[0] = left;
                    answer[1] = right + 1;
                    distance = right - left;
                }
            }

            right++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }
}
