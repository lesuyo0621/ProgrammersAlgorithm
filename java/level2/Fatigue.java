public class Fatigue {
    private static int max = 0;
    
    private static void find(int k, int[][] dungeons, boolean[] check, int count){
        for(int i = 0; i < dungeons.length; i++){
            if(check[i]) continue;

            int[] dungeon = dungeons[i];
            if(k >= dungeon[0]){
                check[i] = true;
                find(k - dungeon[1], dungeons, check, count + 1);
                check[i] = false;
            }
        }
        
        max = count > max ? count : max;
    }
    
    private static int solution(int k, int[][] dungeons) {
        boolean[] check = new boolean[dungeons.length];
        
        find(k, dungeons, check, 0);

        return max;
    }
    
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        
        System.out.println(solution(k, dungeons));
    }
}
