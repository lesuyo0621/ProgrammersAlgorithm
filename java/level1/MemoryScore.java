import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MemoryScore {
    public static int[] solution(String[] name, int[] yearning, String[][] photo){
        Map<String, Integer> scoreMap = IntStream.range(0, name.length)
                                                .boxed()
                                                .collect(Collectors.toMap(i -> name[i], i -> yearning[i]));

        int[] result = new int[photo.length];
        for(int i = 0; i < photo.length; i++){
            int score = 0;
            for(int j = 0; j < photo[i].length; j++){
                score += scoreMap.getOrDefault(photo[i][j], 0);
            }
            result[i] = score;
        }

        return result;
    }
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        System.out.println(Arrays.toString(solution(name, yearning, photo)));
    }
}
