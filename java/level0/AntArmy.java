public class AntArmy {
    public static int solution(int hp) {
        int result = 0;

        for(int i = 0; i < 3; i++){
            result += hp / (5 - (2 * i));
            hp %= 5 - (2 * i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(24));
    }
}
