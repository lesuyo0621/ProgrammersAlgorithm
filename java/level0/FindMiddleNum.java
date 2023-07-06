import java.util.Arrays;

public class FindMiddleNum {
    private static int solution(int[] array){
        Arrays.sort(array);
        return array[array.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 7, 10, 11}));
    }
}