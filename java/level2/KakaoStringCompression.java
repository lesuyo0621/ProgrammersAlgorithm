public class KakaoStringCompression {
    public int solution(String s) {
        int answer = 1001;
        StringBuilder nsb = new StringBuilder();
        StringBuilder csb = new StringBuilder();
        int num = 0;
        int index = 0;

        nsb.append(s);

        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            while (nsb.length() != 0) {
                if (i <= nsb.length()) {
                    String check = nsb.substring(0, i);
                    while (index + i <= nsb.length() && check.equals(nsb.substring(index, index + i))) {
                        num++;
                        index += i;
                    }
                    nsb.delete(0, index);
                    if (num > 1) {
                        csb.append(num);
                    }
                    csb.append(check);
                    index = 0;
                    num = 0;
                } else {
                    csb.append(nsb);
                    nsb.delete(0, nsb.length());
                }
            }

            if (answer > csb.length()) {
                answer = csb.length();
            }

            nsb.append(s);
            csb.delete(0, csb.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "abcabcdede";

        KakaoStringCompression sc = new KakaoStringCompression();
        System.out.println(sc.solution(s));
    }
}