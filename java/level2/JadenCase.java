public class JadenCase {
    private static String solution(String s){
        StringBuilder sb = new StringBuilder();
        boolean space = true;

        for(String str : s.split("")){
            sb.append(space ? str.toUpperCase() : str.toLowerCase());
            space = " ".equals(str) ? true : false;
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(solution("for the last week"));
    }
}
