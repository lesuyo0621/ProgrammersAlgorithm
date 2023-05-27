public class StringReplace {
    public static void main(String[] args) {
        int s = 2;
        String my_string = "He11oWorld";
        String overwrite_string = "lloWorl";

        System.out.println(my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length(), my_string.length()));
    }
}
