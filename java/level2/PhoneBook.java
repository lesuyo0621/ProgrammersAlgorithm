import java.util.Arrays;

public class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].length() < phone_book[i].length())
                    continue;

                if (phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] phone_book = { "12", "123", "1235", "567", "88" };

        PhoneBook pb = new PhoneBook();
        System.out.println(pb.solution(phone_book));
    }
}