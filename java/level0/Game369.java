public class Game369 {
    private static int solution(int order) {
        int answer = 0;

        String[] orderStringArr = String.valueOf(order).split("");
        for (String o : orderStringArr) {
            int i = Integer.parseInt(o);
            if (i != 0 && i % 3 == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
