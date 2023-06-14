import java.util.Arrays;

public class KeyPad {
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int currentLeft = 10;
        int currentRight = 12;

        int[][] distanceFrom2 = {{1, 0, 1},
                                 {2, 1, 2},
                                 {3, 2, 3},
                                 {4, 3, 4}};

        int[][] distanceFrom5 = {{2, 1, 2},
                                 {1, 0, 1},
                                 {2, 1, 2},
                                 {3, 2, 3}};

        int[][] distanceFrom8 = {{3, 2, 3},
                                 {2, 1, 2},
                                 {1, 0, 1},
                                 {2, 1, 2}};

        int[][] distanceFrom0 = {{4, 3, 4},
                                 {3, 2, 3},
                                 {2, 1, 2},
                                 {1, 0, 1}};

        Integer[] leftNum = {1, 4, 7};
        Integer[] rightNum = {3, 6, 9};

        for(int i = 0; i < numbers.length; i++){
            int target = numbers[i];
            if(target == 0) target = 11;

            if(Arrays.asList(leftNum).indexOf(target) > -1){
                sb.append("L");
                currentLeft = target;
            }else if(Arrays.asList(rightNum).indexOf(target) > -1){
                sb.append("R");
                currentRight = target;
            }else{
                int leftRow = (currentLeft - 1) / 3;
                int leftColumn = (currentLeft + 2) % 3;
                int rightRow = (currentRight - 1) / 3;
                int rightColumn = (currentRight + 2) % 3;

                int leftDistance = 0;
                int rightDistance = 0;

                if(target == 2){
                    leftDistance = distanceFrom2[leftRow][leftColumn];
                    rightDistance = distanceFrom2[rightRow][rightColumn];
                }else if(target == 5){
                    leftDistance = distanceFrom5[leftRow][leftColumn];
                    rightDistance = distanceFrom5[rightRow][rightColumn];
                }else if(target == 8){
                    leftDistance = distanceFrom8[leftRow][leftColumn];
                    rightDistance = distanceFrom8[rightRow][rightColumn];
                }else if(target == 11){
                    leftDistance = distanceFrom0[leftRow][leftColumn];
                    rightDistance = distanceFrom0[rightRow][rightColumn];
                }

                if(leftDistance < rightDistance){
                    sb.append("L");
                    currentLeft = target;
                }else if(leftDistance > rightDistance){
                    sb.append("R");
                    currentRight = target;
                }else{
                    if(hand.equals("right")){
                        sb.append("R");
                        currentRight = target;
                    }else{
                        sb.append("L");
                        currentLeft = target;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        String hand = "right";

        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

//        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//        String hand = "right";

        System.out.println(solution(numbers, hand));
    }
}
