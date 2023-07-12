import java.util.*;
import java.util.stream.Collectors;

public class Tangerine {
    private static int solution(int k, int[] tangerine){
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < tangerine.length; i++){
            int size = tangerine[i];
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        List<Integer> list = map.values().stream()
                .sorted((v1, v2) -> v2 - v1)
                .collect(Collectors.toList());

        for(int count : list){
            k -= count;
            answer++;
            if(k <= 0) break;
        }

        return answer;
    }
    
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        
        System.out.println(solution(k, tangerine));
    }
}
