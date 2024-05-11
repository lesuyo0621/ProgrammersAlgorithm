import java.util.Arrays;

public class HigherPeopleCount {
    public static int solution(int[] array, int height){
        return (int) Arrays.stream(array)
                .filter(i -> i > height)
                .count();
    }

    public static void main(String[] args) {
        int[] array = {149, 180, 192, 170};
        int height = 167;

        System.out.println(solution(array, height));
    }
}
