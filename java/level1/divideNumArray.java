import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class divideNumArray {

    // My first answer (1.00ms ~ 4.20ms)
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int n = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i : arr) {
            if (i % divisor == 0) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            answer = new int[] { -1 };
        } else {
            answer = new int[list.size()];
            for (int item : list) {
                answer[n++] = item;
            }
            Arrays.sort(answer);
        }
        return answer;
    }

    // My second answer... But slower than first.. (6.00ms ~ 18.00ms)
    public int[] solution2(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(x -> x % divisor == 0).sorted().toArray();
        int[] answer2 = { -1 };

        return answer.length == 0 ? answer2 : answer;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 9, 7, 10 };
        int[] arr2 = { 3, 2, 6 };

        int divisor = 5;

        divideNumArray dv = new divideNumArray();
        System.out.println(Arrays.toString(dv.solution(arr, divisor)));
    }
}