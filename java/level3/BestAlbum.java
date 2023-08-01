import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BestAlbum {
    private static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalCountMap = new HashMap<>();
        Map<String, HashMap<Integer, Integer>> countMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int count = plays[i];

            totalCountMap.put(genre, totalCountMap.getOrDefault(genre, 0) + count);

            HashMap<Integer, Integer> cm = countMap.getOrDefault(genre, new HashMap<>());
            cm.put(i, count);
            countMap.put(genre, cm);
        }

        List<String> keys = totalCountMap.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .flatMap(e -> Stream.of(e.getKey()))
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();
        for(String key : keys){
            HashMap<Integer, Integer> cm = countMap.get(key);
            List<Integer> numberList = cm.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e1.getValue() == e2.getValue() ? e1.getKey() - e2.getKey() : e2.getValue() - e1.getValue())
                    .flatMap(e -> Stream.of(e.getKey()))
                    .collect(Collectors.toList());

            IntStream.range(0, numberList.size())
                    .filter(i -> i < 2)
                    .forEach(i -> answer.add(numberList.get(i)));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }
}
