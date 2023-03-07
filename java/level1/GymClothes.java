import java.util.Arrays;

public class GymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int left = 0;
        int right = 0;
        int index = -1;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            index = Arrays.binarySearch(reserve, lost[i]);
            if (index >= 0) {
                reserve[index] = -1;
                lost[i] = -1;
            }
        }

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int j = 0; j < lost.length; j++) {
            left = lost[j] - 1;
            right = lost[j] + 1;
            if (lost[j] == -1) {
                continue;
            } else {
                if (Arrays.binarySearch(reserve, left) >= 0) {
                    index = Arrays.binarySearch(reserve, left);
                    reserve[index] = -1;
                    Arrays.sort(reserve);
                } else if (Arrays.binarySearch(reserve, right) >= 0) {
                    index = Arrays.binarySearch(reserve, right);
                    reserve[index] = -1;
                    Arrays.sort(reserve);
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] lost = { 3, 9, 10 };
        int[] reserve = { 3, 8, 9 };
        int n = 10;

        GymClothes gm = new GymClothes();
        System.out.println(gm.solution(n, lost, reserve));

    }
}
