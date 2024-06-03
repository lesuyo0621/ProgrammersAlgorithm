import java.util.LinkedList;
import java.util.List;

public class AddRemoveAtArray {
    private static List<Integer> solution(int[] arr, boolean[] flag) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];

            if (flag[i]) {
                for (int j = 0; j < n*2; j++) {
                    list.add(n);
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (!list.isEmpty()) {
                        list.removeLast();
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 4, 1, 3}, new boolean[]{true, false, true, false, false}));
    }
}
