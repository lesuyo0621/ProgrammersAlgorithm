import java.util.HashMap;
import java.util.Map;

public class DiceGame3 {
    private static int solution(int a, int b, int c, int d){
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        switch (map.size()){
            case 1:
                result = a * 1111;
                break;
            case 2:
                if(map.values().contains(3)){
                    int p = map.keySet().stream().filter(k -> map.get(k) == 3).findFirst().get();
                    int q = map.keySet().stream().filter(k -> k != p).findFirst().get();
                    result = (int) Math.pow(10 * p + q, 2);
                }else{
                    result = map.keySet().stream().reduce((x, y) -> (x + y) * Math.abs(x - y)).get().intValue();
                }
                break;
            case 3:
                result = map.keySet().stream().filter(k -> map.get(k) != 2).reduce((x, y) -> x * y).get().intValue();
                break;
            case 4:
                result = map.keySet().stream().mapToInt(i -> i).min().getAsInt();
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 2, 2, 2));
        System.out.println(solution(4, 1, 4, 4));
        System.out.println(solution(6, 3, 3, 6));
        System.out.println(solution(2, 5, 2, 6));
        System.out.println(solution(6, 4, 2, 5));
    }
}
