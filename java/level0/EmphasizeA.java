public class EmphasizeA {
    private static String solution(String myString) {
        return myString.toLowerCase().replaceAll("a", "A");
    }

    public static void main(String[] args) {
        System.out.println(solution("abstract algebra"));
    }
}
