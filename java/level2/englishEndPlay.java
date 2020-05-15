import java.util.ArrayList;
import java.util.Arrays;

public class englishEndPlay {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> record = new ArrayList<String>();
        int cycle = 1;
        String lastWord;
        char lastWordEndSpell;
        char playerWord;

        record.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            // 마지막 단어 가져오기
            lastWord = record.get(record.size() - 1);

            // 마지막 단어의 마지막 스펠링
            lastWordEndSpell = lastWord.charAt(lastWord.length() - 1);

            // 지금 말한 사람 단어의 처음 스펠링
            playerWord = words[i].charAt(0);

            // 회차 체크
            if (i % n == 0) {
                cycle++;
            }

            // 중복이냐 체크
            if (record.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = cycle;
                return answer;

                // 마지막 단어의 스펠링과 지금 말한 단어의 처음 스펠링틀리냐
            } else if (lastWordEndSpell != playerWord) {
                answer[0] = i % n + 1;
                answer[1] = cycle;
                return answer;
            } else {
                record.add(words[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        englishEndPlay ep = new englishEndPlay();

        int n = 5;
        String[] words = { "hello", "observe", "effecr", "take", "either", "recognize", "encourage", "ensure",
                "establish", "hang", "gather", "refer", "reference", "estimate", "executive" };

        System.out.println(Arrays.toString(ep.solution(n, words)));
    }
}