import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OpenChatRoom {
    private static String[] solution(String[] record) {
        int size = 0;
        Map<String, String> nickname = new HashMap<>();
        Map<String, String> suffix = new HashMap<>();
        suffix.put("Enter", "님이 들어왔습니다.");
        suffix.put("Leave", "님이 나갔습니다.");

        for (String r : record) {
            String[] rArr = r.split(" ");

            switch (rArr[0]) {
                case "Enter" :
                    size++;
                case "Change" :
                    nickname.put(rArr[1], rArr[2]);
                    break;
                case "Leave" :
                    size++;
                    break;
            }
        }

        String[] answer = new String[size];
        int i = 0;
        for (String r : record) {
            String[] rArr = r.split(" ");

            if (!rArr[0].equals("Change")) {
                answer[i] = nickname.get(rArr[1]) + suffix.get(rArr[0]);
                i++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }
}
