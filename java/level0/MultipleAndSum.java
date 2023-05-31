import java.util.stream.IntStream;

public class MultipleAndSum {
    public static int solution(int[] num_list){
        int multiple = IntStream.range(0, num_list.length).reduce(1, (acc, i) -> acc * num_list[i]);
        int sum = IntStream.range(0, num_list.length).map(i -> num_list[i]).sum();

        return multiple > sum * sum ? 0 : 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 5, 2, 1}));
    }
}
