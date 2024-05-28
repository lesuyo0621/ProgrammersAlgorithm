public class NearlyOne {
    private static int solution(int[] arr, int idx) {
        for(int i = idx; i < arr.length; i++) {
            if(arr[i] == 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 0, 0, 1}, 1));
    }
}
