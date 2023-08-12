public class InstallStation {
    private static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int power = 1 + (2 * w);

        int index = 1;
        for(int station : stations){
            int offCount = (station - w) - index;

            if(offCount > 0){
                answer += offCount / power;
                answer += offCount % power > 0 ? 1 : 0;
            }

            index = station + w + 1;
        }

        if(n >= index){
            int offCount = n - index + 1;

            answer += offCount / power;
            answer += offCount % power > 0 ? 1 : 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;

        System.out.println(solution(n, stations, w));
    }
}
