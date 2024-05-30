public class FindNumber {
    private static int solution(int num, int k) {
        String numStr = String.valueOf(num);
        String kStr = String.valueOf(k);
        int index = numStr.indexOf(kStr);

        return index == -1 ? index : index + 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(29183, 1));
    }
}
