import java.util.ArrayList;
import java.util.List;

public class CollectionDictionary {
    private static List<String> list = new ArrayList<>();

    private static void dfs(String str, int len) {
        if(len > 5) return;
        list.add(str);
        for(int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
    }

    private static int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }

    public static void main(String[] args) {
        System.out.println(solution("AAAE"));
    }
}
