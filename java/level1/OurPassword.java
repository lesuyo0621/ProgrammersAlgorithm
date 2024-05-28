public class OurPassword {
    private static String solution(String s, String skip, int index) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            for (int j = 0; j < index; j++) {
                c += 1;
                if(c > 'z') c = 'a';

                if(skip.contains(String.valueOf(c))) {
                    j--;
                }
            }

            chars[i] = c;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5));
    }
}
