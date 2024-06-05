import java.util.*;

public class GetReportResults {
    private static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> count = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();

        for (String id :id_list) {
            reportMap.put(id, new HashSet<>());
            count.put(id, 0);
        }

        for (String r : report) {
            String[] rArr = r.split(" ");
            String user = rArr[0];
            String reportedUser = rArr[1];

            Set<String> reportList = reportMap.get(user);
            if (!reportList.contains(reportedUser)) {
                count.put(reportedUser, count.get(reportedUser) + 1);
                reportList.add(reportedUser);
                reportMap.put(user, reportList);
            }
        }

        for (int i = 0; i < answer.length; i++) {
            String id = id_list[i];

            Set<String> reportList = reportMap.get(id);
            for (String r : reportList) {
                if (count.get(r) >= k) answer[i]++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2)));
    }
}
