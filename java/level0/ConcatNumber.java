import java.util.Arrays;
import java.util.stream.Collectors;

public class ConcatNumber {
    public static int solution(int[] num_list){
        String even = Arrays.stream(num_list).filter(num -> num % 2 == 0).mapToObj(String::valueOf).collect(Collectors.joining());
        String odd = Arrays.stream(num_list).filter(num -> num % 2 == 1).mapToObj(String::valueOf).collect(Collectors.joining());

        return Integer.parseInt(even) + Integer.parseInt(odd);
    }
    public static void main(String[] args) {
        int[] num_list = new int[]{3, 4, 5, 2, 1};
        System.out.println(solution(num_list));
    }
}
