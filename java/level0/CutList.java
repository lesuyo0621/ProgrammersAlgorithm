import java.util.Arrays;

public class CutList {
    private static int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = null;
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        switch (n) {
            case 1:
                answer = Arrays.copyOfRange(num_list, 0, b + 1);
                break;
            case 2:
                answer = Arrays.copyOfRange(num_list, a, num_list.length);
                break;
            case 3:
                answer = Arrays.copyOfRange(num_list, a, b + 1);
                break;
            case 4:
                answer = new int[((b - a + 1) / c) + ((b - a + 1) % c > 0 ? 1 : 0)];

                for (int i = 0; i < answer.length; i++) {
                    answer[i] = num_list[a + (i * c)];
                }
                break;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{1, 5, 2}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
