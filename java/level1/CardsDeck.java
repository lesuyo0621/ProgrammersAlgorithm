public class CardsDeck {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        boolean success = false;
        int cards1Index = 0;
        int cards2Index = 0;

        for(int i = 0; i < goal.length; i++){
            if(cards1Index < cards1.length && goal[i].equals(cards1[cards1Index])){
                cards1Index++;
            }else if(cards2Index < cards2.length && goal[i].equals(cards2[cards2Index])){
                cards2Index++;
            }else{
                break;
            }
            if(i == goal.length - 1) success = true;
        }

        return success ? "Yes" : "No";
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(solution(cards1, cards2, goal));
    }
}
