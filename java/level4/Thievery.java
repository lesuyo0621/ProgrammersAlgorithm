public class Thievery {
    private static int solution(int[] money) {
        if(money.length == 1) return money[0];
        if(money.length == 2) return Math.max(money[0], money[1]);

        int[] memo = new int[money.length - 1];
        memo[0] = money[0];
        memo[1] = money[1];

        for(int i = 2; i < memo.length; i++){
            if(i - 2 == 0){
                memo[i] = money[i] + memo[0];
                continue;
            }

            int num = Math.max(memo[i - 2], memo[i - 3]);
            memo[i] = money[i] + num;
        }

        int[] memo2 = new int[money.length];
        memo2[0] = money[0];
        memo2[1] = money[1];
        memo2[2] = money[2];

        for(int i = 3; i < memo2.length; i++){
            if(i - 3 == 0){
                memo2[i] = money[i] + memo2[1];
                continue;
            }

            int num = Math.max(memo2[i - 2], memo2[i - 3]);
            memo2[i] = money[i] + num;
        }

        int max1 = Math.max(memo[memo.length - 1], memo[memo.length - 2]);
        int max2 = Math.max(memo2[memo2.length - 1], memo2[memo2.length - 2]);

        return max1 > max2 ? max1 : max2;
    }

    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};

        System.out.println(solution(money));
    }
}
