public class RemoveVowel {
    private static String solution(String my_string) {
        return my_string.replaceAll("[aeiou]", "");
    }

    public static void main(String[] args) {
        System.out.println(solution("nice to meet you"));
    }
}
