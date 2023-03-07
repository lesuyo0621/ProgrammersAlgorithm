public class CountPY {
    // My first
    boolean solution(String s) {
        boolean answer = true;
        int pcount = 0;
        int ycount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P')
                pcount++;
            if (s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                ycount++;
        }

        answer = pcount == ycount;

        return answer;
    }

    // Use IntStream
    boolean solution2(String s) {
        s = s.toUpperCase();

        return s.chars().filter(e -> 'P' == e).count() == s.chars().filter(e -> 'Y' == e).count();
    }

    public static void main(String[] args) {
        String s = "Pyy";

        CountPY cpy = new CountPY();
        System.out.println(cpy.solution(s));
    }
}