public class AlienLanguageDictionary {
    private static int solution(String[] spell, String[] dic) {
        int answer = 2;

        for (String d : dic) {
            for (int i = 0; i < spell.length; i++) {
                if (d.indexOf(spell[i]) == -1) break;
                if (i == spell.length - 1) answer = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"p", "o", "s"}, new String[]{"sod", "eocd", "qixm", "adio", "soo"}));
    }
}
