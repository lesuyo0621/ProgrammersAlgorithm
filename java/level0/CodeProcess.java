public class CodeProcess {
    public static String solution(String code){
        int mode = 0;
        String answer = "";

        for(int i = 0; i < code.length(); i++){
            char c = code.charAt(i);
            if(mode == 0){
                if(c == '1'){
                    mode = 1;
                }else if(i % 2 == 0){
                    answer += c;
                }
            }else{
                if(c == '1'){
                    mode = 0;
                }else if(i % 2 == 1){
                    answer += c;
                }
            }
        }
        return answer.length() == 0 ? "EMPTY" : answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc1abc1abc"));
    }
}
