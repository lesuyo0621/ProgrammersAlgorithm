import java.util.Arrays;

public class DescString {
    public String solution(String s) {

        char[] c = s.toCharArray();
        Arrays.sort(c);

        return new StringBuilder(new String(c)).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "AZbcdefg";

        DescString ds = new DescString();
        System.out.println(ds.solution(s));
    }
}