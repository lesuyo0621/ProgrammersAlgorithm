import java.util.Stack;

public class MakeBigNumG {

    // 내 첫 풀이
    public String solution(String number, int k) {
        int index = 0;
        int time = number.length() - k;
        int max = number.charAt(index);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < time; i++) {
            for (int j = index; j < number.length() - (time - i) + 1; j++) {
                if (number.charAt(j) > number.charAt(index)) {
                    index = j;
                }
            }
            sb.append(number.charAt(index));
            index++;
            if (index < number.length()) {
                max = number.charAt(index);
            }
        }
        String answer = sb.toString();
        return answer;
    }

    /*
     * 조합으로 풀려고 했는데 테스트케이스는 다 맞으나 채점에서 1, 11, 12케이스 만 맞고 나머진 다 틀림... 생각해보니 이건
     * 완전탐색이네..
     * 
     * String answer = "0";
     * 
     * 
     * public String solution(String number, int k) {
     * 
     * String[] array = number.split(""); int[] select = new int[number.length() -
     * k];
     * 
     * combination(number.length() - k, 0, array, select);
     * 
     * return answer; }
     * 
     * public void combination(int time, int from, String[] array, int[] select) {
     * 
     * if (time == 0) { StringBuilder sb = new StringBuilder(); for (int i : select)
     * { sb.append(array[i]); } if (Integer.parseInt(answer) <
     * Integer.parseInt(sb.toString())) { answer = sb.toString(); } return; }
     * 
     * for (int j = from; j < array.length; j++) { select[select.length - time] = j;
     * combination(time - 1, j + 1, array, select); } }
     */

    // 베스트 답변인 거 같음.. 스택 이용
    public String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {

        String number = "4177252841";
        int k = 4;

        MakeBigNumG t = new MakeBigNumG();
        System.out.println(t.solution(number, k));
    }
}