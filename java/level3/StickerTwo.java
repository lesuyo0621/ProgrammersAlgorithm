public class StickerTwo {
    public static int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);

        int[] memo = new int[sticker.length - 1];
        memo[0] = sticker[0];
        memo[1] = sticker[1];

        for(int i = 2; i < memo.length; i++){
            if(i - 2 == 0){
                memo[i] = sticker[i] + memo[0];
                continue;
            }

            int num = Math.max(memo[i - 2], memo[i - 3]);
            memo[i] = sticker[i] + num;
        }

        int[] memo2 = new int[sticker.length];
        memo2[0] = sticker[0];
        memo2[1] = sticker[1];
        memo2[2] = sticker[2];

        for(int i = 3; i < memo2.length; i++){
            if(i - 3 == 0){
                memo2[i] = sticker[i] + memo2[1];
                continue;
            }

            int num = Math.max(memo2[i - 2], memo2[i - 3]);
            memo2[i] = sticker[i] + num;
        }

        int max1 = Math.max(memo[memo.length - 1], memo[memo.length - 2]);
        int max2 = Math.max(memo2[memo2.length - 1], memo2[memo2.length - 2]);

        return max1 > max2 ? max1 : max2;
    }

    public static void main(String[] args) {
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
//        int[] sticker = {1, 3, 2, 5, 4};
//        int[] sticker = {1};
//        int[] sticker = {1, 2};
//        int[] sticker = {1, 2, 2};
//        int[] sticker = {4, 3, 2, 9, 4};

        System.out.println(solution(sticker));
    }
}
