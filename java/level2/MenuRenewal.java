import java.util.*;

public class MenuRenewal {
    private static void find(StringBuilder sb, char[] order, int index, Map<String, Integer>[] check) {
        if (index >= order.length) {
            return;
        }

        for (int i = index; i < order.length; i++) {
            sb.append(order[i]);
            String menu = sb.toString();
            int ml = menu.length();

            if (check[ml] != null) {
                check[ml].put(menu, check[ml].getOrDefault(menu, 0) + 1);
            }

            find(sb, order, ++index, check);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    private static List<String> solution(String[] orders, int[] course) {
        Map<String, Integer>[] check = new HashMap[11];
        for (int c : course) {
            check[c] = new HashMap<>();
        }

        for (int i = 0; i < orders.length; i++) {
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            orders[i] = new String(tmp);
        }

        StringBuilder sb = new StringBuilder();
        for (String order : orders) {
            char[] oc = order.toCharArray();

            find(sb, oc, 0, check);
            sb.setLength(0);
        }

        List<String> answer = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        for (int c : course) {
            Map<String, Integer> map = check[c];
            tmp.clear();

            int max = 0;
            for (String key : map.keySet()) {
                int count = map.get(key);

                if (count >= 2) {
                    if (count > max) {
                        tmp.clear();
                        tmp.add(key);
                        max = count;
                    } else if (count == max) {
                        tmp.add(key);
                    }
                }
            }

            for (int i = 0; i < tmp.size(); i++) {
                answer.add(tmp.get(i));
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}));
    }
}
