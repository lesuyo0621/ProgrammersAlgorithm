import java.util.HashSet;
import java.util.Set;

public class PhoneKeMon {
    public static int solution(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            s.add(nums[i]);
        }

        return Integer.min(nums.length / 2, s.size());
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3}));
    }
}
