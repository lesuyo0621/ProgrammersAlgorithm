import java.util.HashSet;
import java.util.Set;

public class TheNumberOfSumsOfConsecutiveSubsequences {
    private static int solution(int[] elements){
        Set<Integer> set = new HashSet<>();
        int l = 1;

        while (l <= elements.length){
            for(int i = 0; i < elements.length; i++){
                int sum = 0;
                for(int j = 0; j < l; j++){
                    sum += elements[(i + j) % elements.length];
                }
                set.add(sum);
            }
            l++;
        }

        return set.size();
    }

    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        System.out.println(solution(elements));
    }
}
