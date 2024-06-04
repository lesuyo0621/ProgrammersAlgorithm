public class FindLongestSubstringEndingWithSpecificString {
    private static String solution(String myString, String pat) {
        int index = myString.lastIndexOf(pat) + pat.length();

        return myString.substring(0, index);
    }

    public static void main(String[] args) {
        System.out.println(solution("AbCdEFG", "dE"));
    }
}
