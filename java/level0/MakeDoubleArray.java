import java.util.Arrays;

public class MakeDoubleArray {
    private static int[] solution(int[] numbers){
        return Arrays.stream(numbers).map(i -> i * 2).toArray();
    }
    
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(numbers)));
    }
}
