public class Babbling2 {
    private static int solution(String[] babbling) {
        int count = 0;
        String[] words = new String[]{"aya", "ye", "woo", "ma"};

        for(String b : babbling) {
            int wordIndex = -1;
            String rw = null;

            while(!b.equals(rw)) {
                if(rw != null) b = rw;

                for(int i = 0; i < words.length; i++) {
                    if(b.startsWith(words[i]) && i != wordIndex) {
                        rw = b.replaceFirst(words[i], "");
                        wordIndex = i;
                        break;
                    }
                }

                if(rw == null) break;
            }

            if(b.length() == 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"aya", "yee", "u", "maa"}));
    }
}
