public class FoodFight {
    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");

        for(int i = food.length - 1; i >= 0; i--){
            int count = food[i];
            for(int j = 1; j <= count / 2; j++){
                sb.append(i);
                sb.insert(0, i);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));
    }
}
