public class FindInt {
    private static int solution(int[] num_list, int n) {
        for(int i = 0; i < num_list.length; i++) {
            if(num_list[i] == n) return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}, 3));
    }
}
