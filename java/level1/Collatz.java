public class Collatz {
    public int solution(long num) {
        int answer = 0;
        
        while(num != 1){
            num = num % 2 == 0 ? num / 2 : num * 3 + 1;
            answer++;
        }
        
        return answer > 499 ? -1 : answer;
    }

    public int solution2(long num){
        int answer = 0;
        
        for(int i = 0; i < 500; i++){
            if(num == 1) return answer;
            num = num % 2 == 0 ? num / 2 : num * 3 + 1;
            answer++;
        }

        return -1;
    }
}