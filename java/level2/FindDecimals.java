import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FindDecimals {
    private static int answer = 0;

    private static boolean[] setDecimals(int max){
        boolean[] decimals = new boolean[max + 1];
        Arrays.fill(decimals, true);
        decimals[0] = false;
        decimals[1] = false;

        for(int i = 2; i * i <= max; i++){
            for(int j = 2; i * j <= max; j++){
                decimals[i * j] = false;
            }
        }

        return decimals;
    }

    private static void find(StringBuilder sb, boolean[] check, String[] numbers, boolean[] decimals, boolean[] count){
        int num = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 0;

        if(decimals[num] && !count[num]){
            answer++;
            count[num] = true;
        }

        if(sb.length() == numbers.length) return;

        for(int i = 0; i < numbers.length; i++){
            if(check[i]) continue;

            check[i] = true;
            sb.append(numbers[i]);

            find(sb, check, numbers, decimals, count);

            check[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static int solution(String numbers) {
        String[] numberStrArr = numbers.split("");

        int max = Integer.parseInt(Arrays.stream(numberStrArr).sorted(Comparator.reverseOrder()).collect(Collectors.joining()));
        boolean[] decimals = setDecimals(max);

        StringBuilder sb = new StringBuilder();
        find(sb, new boolean[numbers.length()], numberStrArr, decimals, new boolean[decimals.length]);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
}
