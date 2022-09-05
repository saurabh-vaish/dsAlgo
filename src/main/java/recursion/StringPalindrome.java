package recursion;

/**
 * @Author saurabh vaish
 * @Date 15-08-2022
 */
public class StringPalindrome {

    public static void main(String[] args) {
        System.out.println(check("mom"));
    }

    public static boolean check(String str){
        if(str.isEmpty())return false;
        if(str.length()==1)return true;
        if(str.charAt(0)!=str.charAt(str.length()-1))return false;
        return check(str.substring(1,str.length()-1));
    }
}
