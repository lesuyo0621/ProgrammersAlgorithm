public class NLettersOfString {
    public static String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(solution("ProgrammerS123", 11));
    }
}
