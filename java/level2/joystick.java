public class joystick {
    public int solution(String name) {
        int answer = 0;
        int[] check = new int[name.length()];
        int startIndex = 0;

        // 이동 계산
        for (int i = 0; i < name.length(); i++) {
            int AtoZ = (int) name.charAt(i) - 65;
            int ZtoA = 90 - (int) name.charAt(i) + 1;
            if (AtoZ >= ZtoA) {
                answer += ZtoA;
            } else {
                answer += AtoZ;
            }

            if (AtoZ == 0) {
                check[i] = 1;
            } else {
                check[i] = 0;
            }
        }

        check[0] = 1;

        while (true) {
            int rightNum = 0;
            int leftNum = 0;
            int sum = 0;

            for (int last = 0; last < check.length; last++) {
                sum = sum + check[last];
            }

            if (sum == check.length) {
                break;
            }
            // right
            for (int j = 1; j < check.length; j++) {
                if (startIndex + j < check.length) {
                    if (check[startIndex + j] != 1) {
                        rightNum = j;
                        break;
                    }
                } else {
                    if (check[startIndex + j - check.length] != 1) {
                        rightNum = j;
                        break;
                    }
                }
            }

            // left
            for (int j = 1; j < check.length; j++) {
                if (startIndex - j >= 0) {
                    if (check[startIndex - j] != 1) {
                        leftNum = j;
                        break;
                    }
                } else {
                    if (check[check.length + (startIndex - j)] != 1) {
                        leftNum = j;
                        break;
                    }
                }
            }

            if (leftNum >= rightNum) {
                for (int k = 1; k <= rightNum; k++) {
                    if (startIndex + k >= check.length) {
                        check[(startIndex + k) - check.length] = 1;
                    } else {
                        check[startIndex + k] = 1;
                    }
                }
                answer += rightNum;
                if (startIndex + rightNum >= check.length) {
                    startIndex = (startIndex + rightNum) - check.length;
                } else {
                    startIndex = startIndex + rightNum;
                }
            } else {
                for (int p = 1; p <= leftNum; p++) {
                    if (startIndex - p >= 0) {
                        check[startIndex - p] = 1;
                    } else {
                        check[check.length + (startIndex - p)] = 1;
                    }
                }
                answer += leftNum;
                if (startIndex - leftNum >= 0) {
                    startIndex = startIndex - leftNum;
                } else {
                    startIndex = check.length + (startIndex - leftNum);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String name = "JEROEN";

        joystick j = new joystick();
        System.out.println(j.solution(name));
    }
}