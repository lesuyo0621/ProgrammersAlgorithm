public class BindString {
    private static int solution(String[] strArr) {
        int answer = 0;
        int[] count = new int[31];

        for (String s : strArr) {
            count[s.length()]++;

            answer = Math.max(answer, count[s.length()]);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"a", "bc", "d", "efg", "hi"}));
    }
}
