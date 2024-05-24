import java.util.Arrays;

public class CompareArray {
    private static int solution(int[] arr1, int[] arr2) {
        int answer = 0;

        if(arr1.length != arr2.length) {
            answer = arr1.length > arr2.length ? 1 : -1;
        }else {
            int sum1 = Arrays.stream(arr1).sum();
            int sum2 = Arrays.stream(arr2).sum();

            if(sum1 > sum2) {
                answer = 1;
            }else if(sum1 < sum2) {
                answer = -1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}, new int[]{3, 3, 3, 3, 3}));
    }
}
