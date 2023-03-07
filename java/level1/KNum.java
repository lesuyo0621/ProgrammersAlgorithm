import java.util.Arrays;

public class KNum {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] slice = new int[commands[i][1] - commands[i][0] + 1];
            for (int j = 0; j < slice.length; j++) {
                slice[j] = array[commands[i][0] + j - 1];
            }
            Arrays.sort(slice);
            answer[i] = slice[commands[i][2] - 1];
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

        KNum kn = new KNum();
        System.out.println(Arrays.toString(kn.solution(array, commands)));
    }
}