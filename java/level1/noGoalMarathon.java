import java.util.HashMap;

public class noGoalMarathon {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hmap = new HashMap<String, Integer>();

        for (int i = 0; i < participant.length; i++)
            if (hmap.containsKey(participant[i])) {
                hmap.put(participant[i], (Integer) hmap.get(participant[i]) + 1);
            } else {
                hmap.put(participant[i], 1);
            }

        for (int i = 0; i < completion.length; i++) {
            hmap.put(completion[i], (Integer) hmap.get(completion[i]) - 1);
        }

        for (Object name : hmap.keySet()) {
            if (hmap.get(name).equals(1))
                answer = (String) name;
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
        String[] completion = { "josipa", "filipa", "marina", "nikola" };

        noGoalMarathon ngm = new noGoalMarathon();
        System.out.println(ngm.solution(participant, completion));
    }

}