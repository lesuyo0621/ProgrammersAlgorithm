public class makePrimeNum {

    public int solution(int[] nums) {
        int answer = 0;
        boolean nonPrime = false;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int target = nums[i] + nums[j] + nums[k];
                    for (int d = 2; d <= Math.sqrt(target); d++) {
                        if (target % d == 0) {
                            nonPrime = true;
                            break;
                        }
                    }
                    if (nonPrime) {
                        nonPrime = false;
                    } else {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4 };

        makePrimeNum mp = new makePrimeNum();
        System.out.println(mp.solution(nums));
    }
}