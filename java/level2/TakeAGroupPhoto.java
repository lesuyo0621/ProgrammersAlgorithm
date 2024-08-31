import java.util.*;

public class TakeAGroupPhoto {
    private static int answer = 0;
    private static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    private static int distanceBetweenPeople(int p1, int p2) {
        if (p2 > p1) {
            int tmp = p1;
            p1 = p2;
            p2 = tmp;
        }

        return p1 - p2 - 1;
    }

    private static boolean isValid(Map<Character, Integer> sequence, String[] data) {
        for (String d : data) {
            char[] dArr = d.toCharArray();

            int p1 = sequence.get(dArr[0]);
            int p2 = sequence.get(dArr[2]);
            char operator = dArr[3];
            int val = Character.getNumericValue(dArr[4]);
            int distance = distanceBetweenPeople(p1, p2);

            boolean isValid = false;
            switch (operator) {
                case '=':
                    isValid = distance == val;
                    break;
                case '>':
                    isValid = distance > val;
                    break;
                case '<':
                    isValid = distance < val;
                    break;
            }

            if (!isValid) return false;
        }

        return true;
    }

    private static void makeSequence(int idx, Map<Character, Integer> sequence, boolean[] used, String[] data) {
        if (idx >= 8) {
            if (isValid(sequence, data)) answer++;
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            sequence.put(friends[i], idx);
            makeSequence(idx + 1, sequence, used, data);
            used[i] = false;
        }
    }

    public static int solution(int n, String[] data) {
        Map<Character, Integer> sequence = new HashMap<>();
        boolean[] used = new boolean[friends.length];
        makeSequence(0, sequence, used, data);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
    }
}
