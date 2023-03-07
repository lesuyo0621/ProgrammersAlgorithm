public class ChangeBinaryRepeat {
    private int change = 0;
    private int zeroDeleteCount = 0;

    private String deleteZero(String s){
        if(s.equals("1")) return s;

        String result = s.replaceAll("0", "");
        zeroDeleteCount += s.length() - result.length();

        return changeBinary(result);
    }

    private String changeBinary(String s){
        String result = Integer.toBinaryString(s.length());
        change++;

        return deleteZero(result);
    }

    public static void main(String[] args) {
        ChangeBinaryRepeat changeBinaryRepeat = new ChangeBinaryRepeat();
        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        changeBinaryRepeat.deleteZero(s1);
        System.out.println(changeBinaryRepeat.change);
        System.out.println(changeBinaryRepeat.zeroDeleteCount);
    }
}
