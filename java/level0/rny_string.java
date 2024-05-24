public class rny_string {
    private static String solution(String rny_string) {
        return rny_string.replaceAll("m", "rn");
    }

    public static void main(String[] args) {
        System.out.println(solution("masterpiece"));
    }
}
