import java.util.Stack;

public class ConvertBracket {
    private static String[] makeUV(String p) {
        StringBuilder sb = new StringBuilder();
        String[] uv = new String[2];

        int[] count = new int[300];
        boolean same = false;
        for (char c : p.toCharArray()) {
            count[c]++;
            sb.append(c);

            if (same) continue;

            if (count['('] == count[')']) {
                uv[0] = sb.toString();
                sb.setLength(0);
                same = true;
            }
        }
        uv[1] = sb.toString();

        return uv;
    }

    private static boolean uIsCorrectBracket(String u) {
        Stack<Character> st = new Stack<>();

        for (char c : u.toCharArray()) {
            if (st.isEmpty() || c == '(') {
                st.push(c);
                continue;
            }

            if (st.peek() == '(') {
                st.pop();
            } else {
                st.push(c);
            }
        }

        return st.isEmpty();
    }

    private static String reverseBracket(String u) {
        StringBuilder sb = new StringBuilder();

        char[] cArr = u.toCharArray();
        for (int i = 1; i < cArr.length - 1; i++) {
            sb.append(cArr[i] == '(' ? ')' : '(');
        }

        return sb.toString();
    }

    private static String makeBracket(String p) {
        if (p.length() == 0) return p;

        String[] uv = makeUV(p);

        if (uIsCorrectBracket(uv[0])) return uv[0] + makeBracket(uv[1]);

        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(makeBracket(uv[1]));
        sb.append(')');
        sb.append(reverseBracket(uv[0]));

        return sb.toString();
    }

    private static String solution(String p) {
        return makeBracket(p);
    }

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
    }
}
