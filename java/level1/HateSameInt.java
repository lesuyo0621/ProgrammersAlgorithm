import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class HateSameInt {

    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i])
                list.add(arr[i]);
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {
        HateSameInt hsi = new HateSameInt();
        int[] data = {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(hsi.solution(data)));
    }
}