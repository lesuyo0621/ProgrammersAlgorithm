import java.util.*;

public class Compression {
    private static List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int index = 27;

        for (int i = 0; i < 26; i++) {
            char c = 'A';
            c += i;

            dictionary.put(String.valueOf(c), i + 1);
        }

        int wIndex = 0;
        while (wIndex < msg.length()) {
            sb.append(msg.charAt(wIndex));

            while (dictionary.containsKey(sb.toString())) {
                wIndex++;
                if (wIndex >= msg.length()) break;

                sb.append(msg.charAt(wIndex));
            }

            if (dictionary.containsKey(sb.toString())) {
                answer.add(dictionary.get(sb.toString()));
            } else {
                dictionary.put(sb.toString(), index);
                index++;

                sb.deleteCharAt(sb.length() - 1);
                answer.add(dictionary.get(sb.toString()));
            }

            sb.setLength(0);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("KAKAO"));
    }
}
