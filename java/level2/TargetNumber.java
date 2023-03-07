public class TargetNumber {

    int answer = 0;

    public int solution(int[] numbers, int target) {
        int index = 0;
        int sum = 0;

        find(index, target, numbers, sum);

        return answer;
    }

    public void find(int index, int target, int[] numbers, int sum) {
        if (index >= numbers.length) {
            if (sum == target) {
                answer++;
                return;
            } else {
                return;
            }
        } else {
            sum += numbers[index];
            find(index + 1, target, numbers, sum);
            sum -= numbers[index];

            sum += numbers[index] * -1;
            find(index + 1, target, numbers, sum);
        }
    }

    public static void main(String[] args) {

        int[] numbers = { 1, 1, 1, 1, 1 };
        int target = 3;

        TargetNumber tn = new TargetNumber();
        System.out.println(tn.solution(numbers, target));
    }
}