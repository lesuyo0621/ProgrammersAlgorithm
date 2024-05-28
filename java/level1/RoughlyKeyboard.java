import java.util.Arrays;

public class RoughlyKeyboard {
    private static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int i = 0; i < targets.length; i++) {
            String t = targets[i];
            int count = 0;

            for(int j = 0; j < t.length(); j++) {
                int min = Integer.MAX_VALUE;

                for(String k : keymap) {
                    int index = k.indexOf(t.charAt(j));

                    if(index != -1 && index < min) {
                        min = index;
                    }
                }

                if(min == Integer.MAX_VALUE) {
                    count = -1;
                    break;
                }else {
                    count += min + 1;
                }
            }

            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};

        System.out.println(Arrays.toString(solution(keymap, targets)));
    }
}
