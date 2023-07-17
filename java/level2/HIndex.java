import java.util.*;

public class HIndex {
    private static int solution(int[] citations){
        int answer = 0;

        citations = Arrays.stream(citations).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
        for(int i = 0; i < citations.length; i++){
            if(i < citations[i]) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }
}
