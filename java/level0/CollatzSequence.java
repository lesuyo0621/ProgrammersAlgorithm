import java.util.*;

public class CollatzSequence {

    private static int[] solution(int n) {
        List<Integer> result = new ArrayList<>();

        result.add(n);
        while(n != 1){
            if(n % 2 == 0){
                n /= 2;
            }else{
                n = 3 * n + 1;
            }
            result.add(n);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(solution(n)));
    }
}
