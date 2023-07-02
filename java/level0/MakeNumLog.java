public class MakeNumLog {

    private static String solution(int[] numLog){
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < numLog.length; i++){
            switch(numLog[i] - numLog[i-1]){
                case 1:
                    sb.append("w");
                    break;
                case -1:
                    sb.append("s");
                    break;
                case 10:
                    sb.append("d");
                    break;
                case -10:
                    sb.append("a");
                    break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
        System.out.println(solution(numLog));
    }
}
