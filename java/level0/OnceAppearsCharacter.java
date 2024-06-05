import java.util.Arrays;

public class OnceAppearsCharacter {
    private static String solution(String s) {
        String answer = "";

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        for (char c : arr) {
            if (s.indexOf(c) == s.lastIndexOf(c)) answer += c;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcadc"));
    }
}
