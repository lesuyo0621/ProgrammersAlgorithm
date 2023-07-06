import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxAndMin {
    private static String solution(String s){
        Map<String, Integer> map = new HashMap<>();
        map.put("min", Integer.MAX_VALUE);
        map.put("max", Integer.MIN_VALUE);
        
        Arrays.stream(s.split(" ")).map(Integer::parseInt).forEach(n -> {
            if(map.get("min") > n) map.put("min", n);
            if(map.get("max") < n) map.put("max", n);
        });
        
        return map.get("min") + " " + map.get("max");
    }
    
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
    }
}
