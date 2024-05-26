import java.util.ArrayList;
import java.util.List;

public class RemoveArrayElement {
    private static int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();

        for(int i : arr) {
            list.add(i);
        }

        for(int d : delete_list) {
            list.remove(Integer.valueOf(d));
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{293, 1000, 395, 678, 94}, new int[]{94, 777, 104, 1000, 1, 12}));
    }
}
