public class FlipString {
    private static String solution(String my_string, int s, int e) {
        String[] arr = my_string.split("");

        String tmp = "";
        for (int i = s, j =e; i <= j && j >= i; i++, j--) {
            tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }

        return String.join("", arr);
    }

    public static void main(String[] args) {
        System.out.println(solution("Progra21Sremm3", 6, 12));
    }
}
