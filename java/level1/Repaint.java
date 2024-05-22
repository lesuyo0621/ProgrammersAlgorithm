public class Repaint {
    private static int solution(int n, int m, int[] section) {
        int answer = 1;

        int start = section[0];
        for(int i = 1; i < section.length; i++) {
            int target = section[i];

            if(m < target - start + 1) {
                answer++;
                start = target;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, new int[]{2, 3, 6}));
    }
}
