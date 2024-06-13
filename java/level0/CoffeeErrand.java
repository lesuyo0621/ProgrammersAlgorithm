public class CoffeeErrand {
    private static int solution(String[] order) {
        int answer = 0;

        for (String o : order) {
            if (o.contains("americano")) answer += 4500;
            else if (o.contains("cafelatte")) answer += 5000;
            else answer += 4500;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"cafelatte", "americanoice", "hotcafelatte", "anything"}));
    }
}
