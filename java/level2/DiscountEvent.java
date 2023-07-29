import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiscountEvent {

    private static boolean canAllDiscount(Map<String, Integer> countMap){
        return countMap.values().stream().allMatch(i -> i == 0);
    }

    private static int solution(String[] want, int[] number, String[] discount){
        int answer = 0;

        Map<String, Integer> countMap = IntStream.range(0, want.length)
                .boxed()
                .collect(Collectors.toMap(i -> want[i], i-> number[i]));

        for(int i = 0; i < 10; i++){
            countMap.computeIfPresent(discount[i], (k, v) -> v - 1);
        }
        if(canAllDiscount(countMap)) answer++;

        for(int i = 10; i < discount.length; i++){
            String target = discount[i];
            String prev = discount[i - 10];

            countMap.computeIfPresent(target, (k, v) -> v - 1);
            countMap.computeIfPresent(prev, (k, v) -> v + 1);

            if(canAllDiscount(countMap)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }
}
