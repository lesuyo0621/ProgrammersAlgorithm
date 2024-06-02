import java.util.Arrays;

public class SplitAndSortString {
    private static String[] solution(String myString) {
        String[] answer = myString.replaceAll("[x]+", " ").strip().split(" ");
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("axbxcxdx")));
    }
}
