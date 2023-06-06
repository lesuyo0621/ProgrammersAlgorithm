import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LastTwoNum {
    public static int[] solution(int[] num_list) {
        int lastNum = num_list[num_list.length - 1];
        int prevNum = num_list[num_list.length - 2];
        int newNum = lastNum > prevNum ? lastNum - prevNum : lastNum * 2;
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        list.add(newNum);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] num_list = {2, 1, 6};
        System.out.println(Arrays.toString(solution(num_list)));
    }
}
