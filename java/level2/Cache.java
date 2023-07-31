import java.util.LinkedList;

public class Cache {
    private static int solution(int cacheSize, String[] cities){
        int time = 0;
        LinkedList<String> cache = new LinkedList<>();

        if(cacheSize == 0) return 5 * cities.length;

        for(String city : cities){
            String c = city.toLowerCase();

            if(cache.contains(c)){
                time += 1;
                cache.remove(c);
            }else{
                time += 5;
                if(cache.size() >= cacheSize){
                    cache.poll();
                }
            }

            cache.add(c);
        }

        return time;
    }

    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Seoul", "Pangyo"};

        System.out.println(solution(cacheSize, cities));
    }
}
