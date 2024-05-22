public class Substring {
    private static int solution(String str1, String str2) {
        return str2.indexOf(str1) > -1 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc", "aabcc"));
    }
}
