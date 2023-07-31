import java.util.*;

public class Tuple {
    private static int[] solution(String s){
        String[] tuple = s.substring(2, s.length() - 2).split("(},\\{)");
        Arrays.sort(tuple, (s1, s2) -> s1.length() - s2.length());

        int[] result = new int[tuple.length];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < result.length; i++){
            int[] nums = Arrays.stream(tuple[i].split(",")).mapToInt(Integer::parseInt).toArray();

            for(int num : nums){
                if(!set.contains(num)){
                    set.add(num);
                    result[i] = num;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        System.out.println(Arrays.toString(solution(s)));
    }
}
