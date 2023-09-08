package string;

/**
 * @Author saurabh vaish
 * @Date 16-08-2023
 */
public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
        String str = "hello";

        System.out.println(reverse(str));
    }

    static String reverse(String str){
        if(str.length()<2){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }

}
