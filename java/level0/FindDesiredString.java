public class FindDesiredString {
    private static int solution(String myString, String pat) {
        return myString.toLowerCase().indexOf(pat.toLowerCase()) > -1 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("AbCdEfG", "aBc"));
    }
}
