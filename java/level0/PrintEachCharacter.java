public class PrintEachCharacter {
    public static void main(String[] args) {
        String a = "abcde";

        a.chars().mapToObj(c -> Character.toString((char) c)).forEach(System.out::println);
    }
}
