public class TailString {
    private static String solution(String[] str_list, String ex) {
        String result = "";

        for(int i = 0; i < str_list.length; i++) {
            if(str_list[i].indexOf(ex) > -1) continue;
            result += str_list[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"abc", "def", "ghi"}, "ef"));
    }
}
