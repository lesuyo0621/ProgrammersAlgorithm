public class NormalSquareNum {
    public long solution(int w, int h) {
        long answer = 0;
        for (int i = 0; i < w; i++) {
            answer = answer + (long) h * i / w;
        }
        answer = answer * 2;
        return answer;
    }

    public static void main(String[] args) {

        int w = 8;
        int h = 12;

        NormalSquareNum nm = new NormalSquareNum();
        System.out.println(nm.solution(w, h));
    }
}