public class OddVsEven {
    public static int solution(int[] num_list) {
        int odd = 0;
        int even = 0;

        for(int i = 0; i < num_list.length; i++) {
            if(i % 2 == 0) even += num_list[i];
            else odd += num_list[i];
        }

        return Integer.max(odd, even);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 2, 6, 1, 7, 6}));
    }
}
