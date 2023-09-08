package string;

/**
 * program to check if any string is rotation of another
 *
 * @Author saurabh vaish
 * @Date 16-08-2023
 */
public class StringRotationOfAnother {

    public static void main(String[] args) {
        String s1 = "aabbcc";
        String s2 = "ccaabb";

        System.out.println(checkRotation(s1,s2));
    }

    private static boolean checkRotation(String s1, String s2) {
        if(s1.length()!=s2.length())return false;
        String concat = s1+s1;
        if(concat.contains(s2))return true;
        return false;
    }

}
