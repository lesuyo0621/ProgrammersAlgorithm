public class CheckSubstring {
    private static int solution(String my_string, String target) {
        return my_string.indexOf(target) > -1 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("banana", "ana"));
    }
}
