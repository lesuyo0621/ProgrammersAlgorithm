import java.util.*;
import java.util.stream.IntStream;

public class ChangeWord {
    private static int solution(String begin, String target, String[] words) {
        if(!Arrays.stream(words).anyMatch(s -> s.equals(target))) return 0;

        Map<String, LinkedList<String>> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            LinkedList<String> list = map.getOrDefault(word, new LinkedList<>());

            for(int j = 0; j < words.length; j++){
                String neighbor = words[j];

                if(IntStream.range(0, word.length()).filter(n -> word.charAt(n) != neighbor.charAt(n)).count() == 1){
                    list.add(neighbor);
                }
            }

            map.put(word, list);

            if(IntStream.range(0, word.length()).filter(n -> word.charAt(n) != begin.charAt(n)).count() == 1){
                LinkedList<String> l = map.getOrDefault(begin, new LinkedList<>());
                l.add(word);
                map.put(begin, l);
            }
        }

        int count = 0;
        Queue<String> queue = map.get(begin);
        while (!queue.isEmpty()){
            count++;

            int size = queue.size();
            for(int i = 0; i < size; i++){
                String s = queue.poll();

                if(s.equals(target)) {
                    return count;
                }else{
                    map.get(s).stream().forEach(str -> queue.add(str));
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin, target, words));
        System.out.println(solution(begin2, target2, words2));
    }
}
