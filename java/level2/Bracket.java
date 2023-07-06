public class Bracket {
    private static boolean solution(String s){
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(count < 0) return false;
            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')') count--;
        }

        return count == 0;
    }
    public static void main(String[] args) {
        System.out.println(solution("()()"));
    }
}
