public class TemplarWeapon {
    public static int solution(int number, int limit, int power) {
        int[] count = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }

        int sum = 0;
        for(int i = 1; i <= number; i++) {
            sum += count[i] > limit ? power : count[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 3, 2));
    }
}
