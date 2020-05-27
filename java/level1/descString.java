import java.util.Arrays;

public class descString {
    public String solution(String s) {

        char[] c = s.toCharArray();
        Arrays.sort(c);

        return new StringBuilder(new String(c)).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "AZbcdefg";

        descString ds = new descString();
        System.out.println(ds.solution(s));
    }
}