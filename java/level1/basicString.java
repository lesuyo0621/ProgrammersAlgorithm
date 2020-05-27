public class basicString {
    public boolean solution(String s) {
        boolean answer = true;

        if (s.length() == 4 || s.length() == 6) {
        } else {
            return answer = false;
        }

        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);

            if (48 > check || check > 57) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "a234";

        basicString bs = new basicString();
        System.out.println(bs.solution(s));
    }
}