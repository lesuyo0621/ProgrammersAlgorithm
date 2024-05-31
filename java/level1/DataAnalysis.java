import java.util.*;

public class DataAnalysis {
    private static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> index = new HashMap<>();
        index.put("code", 0);
        index.put("date", 1);
        index.put("maximum", 2);
        index.put("remain", 3);

        List<int[]> list = new ArrayList<>();
        for (int[] d : data) {
            if (d[index.get(ext)] < val_ext) list.add(d);
        }

        Collections.sort(list, (o1, o2) -> o1[index.get(sort_by)] - o2[index.get(sort_by)]);

        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            int[] d = list.get(i);
            answer[i] = d;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        int[][] answer = solution(data, ext, val_ext, sort_by);
        for (int[] a : answer) {
            System.out.println(Arrays.toString(a));
        }
    }
}
