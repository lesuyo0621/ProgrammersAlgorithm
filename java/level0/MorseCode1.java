import java.util.HashMap;
import java.util.Map;

public class MorseCode1 {
    private static String solution(String letter) {
        Map<String, String> m = new HashMap<>();
        m.put(".-","a");
        m.put("-...","b");
        m.put("-.-.","c");
        m.put("-..","d");
        m.put(".","e");
        m.put("..-.","f");
        m.put("--.","g");
        m.put("....","h");
        m.put("..","i");
        m.put(".---","j");
        m.put("-.-","k");
        m.put(".-..","l");
        m.put("--","m");
        m.put("-.","n");
        m.put("---","o");
        m.put(".--.","p");
        m.put("--.-","q");
        m.put(".-.","r");
        m.put("...","s");
        m.put("-","t");
        m.put("..-","u");
        m.put("...-","v");
        m.put(".--","w");
        m.put("-..-","x");
        m.put("-.--","y");
        m.put("--..","z");

        StringBuilder sb = new StringBuilder();
        for (String l : letter.split(" ")) {
            sb.append(m.get(l));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(".... . .-.. .-.. ---"));
    }
}
