import java.util.*;

public class BannedUser {
    private static final Set<String> ANSWER_SET = new HashSet<>();
    private static final Map<String, Integer> USER_ID_INDEX = new HashMap<>();

    private static List<String>[] makeBannableList(String[] user_id, String[] banned_id) {
        List<String>[] bannable = new ArrayList[banned_id.length];
        for (int i = 0; i < bannable.length; i++) {
            bannable[i] = new ArrayList<>();
        }

        for (int i = 0; i < banned_id.length; i++) {
            char[] banIdChars = banned_id[i].toCharArray();

            for (int j = 0; j < user_id.length; j++) {
                if (banned_id[i].length() != user_id[j].length()) continue;

                char[] userIdChars = user_id[j].toCharArray();

                boolean find = true;
                for (int k = 0; k < userIdChars.length; k++) {
                    if (banIdChars[k] == '*') continue;

                    if (banIdChars[k] != userIdChars[k]) {
                        find = false;
                        break;
                    }
                }

                if (find) bannable[i].add(user_id[j]);
            }
        }

        return bannable;
    }

    private static void countBanList(List<String>[] bannable, boolean[] used, String answer, int count) {
        if (count >= bannable.length) {
            ANSWER_SET.add(answer);
            return;
        }

        List<String> idList = bannable[count];

        for (String id : idList) {
            int index = USER_ID_INDEX.get(id);

            if (used[index]) continue;

            used[index] = true;
            String nextAnswer = answer.replaceFirst(id + ",", "");
            countBanList(bannable, used, nextAnswer, count + 1);
            used[index] = false;
        }
    }

    private static int solution(String[] user_id, String[] banned_id) {
        String userIdStr = "";
        for (String u : user_id) {
            userIdStr += u;
            userIdStr += ",";
        }

        for (int i = 0; i < user_id.length; i++) {
            USER_ID_INDEX.put(user_id[i], i);
        }

        List<String>[] bannable = makeBannableList(user_id, banned_id);

        boolean[] used = new boolean[user_id.length];
        countBanList(bannable, used, userIdStr, 0);

        return ANSWER_SET.size();
    }

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        System.out.println(solution(user_id, banned_id));
    }
}
