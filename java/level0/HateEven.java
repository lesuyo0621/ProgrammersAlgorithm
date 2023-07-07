import java.util.Arrays;
import java.util.stream.IntStream;

public class HateEven {
    private static int[] solution(int n){
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 1).toArray();
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10)));
    }
}
