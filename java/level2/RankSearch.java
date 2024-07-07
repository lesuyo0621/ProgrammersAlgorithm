import java.util.*;

public class RankSearch {
    private static final Map<String, List<Integer>> SCORE = new HashMap<>();

    private static int count(List<Integer> scores, int score) {
        int left = 0;
        int right = scores.size() - 1;

        if (scores.size() == 0) {
            return 0;
        }

        while (left < right) {
            int mid = (left + right) / 2;

            if (scores.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (scores.get(left) < score) {
            return scores.size();
        }

        return left;
    }

    private static void parsingScore(String[] prev, String[] infos, int idx) {
        if (idx >= 4) {
            String query = String.join("", prev);
            int score = Integer.parseInt(infos[4]);

            SCORE.putIfAbsent(query, new ArrayList<>());
            SCORE.get(query).add(score);
            return;
        }

        prev[idx] = infos[idx];
        parsingScore(prev, infos, idx + 1);
        prev[idx] = "-";
        parsingScore(prev, infos, idx + 1);
    }

    private static int[] solution(String[] info, String[] query) {
        for (String i : info) {
            String[] iArr = i.split(" ");

            parsingScore(new String[4], iArr, 0);
        }

        for (String key : SCORE.keySet()) {
            List<Integer> scores = SCORE.get(key);
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < answer.length; i++) {
            String[] qArr = query[i].split(" (and )?");
            int score = Integer.parseInt(qArr[4]);

            String key = String.join("", Arrays.copyOf(qArr, 4));
            List<Integer> scores = SCORE.getOrDefault(key, new ArrayList<>());
            answer[i] = scores.size() - count(scores, score);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }
}
