package recursion;

/**
 * @Author saurabh vaish
 * @Date 14-08-2022
 */
public class StringMerge {

    public static void main(String[] args) {
        System.out.println(merge("adz","bfx"));
    }

    private static String merge(String s1,String s2){
        if(s1==null || s1.isEmpty())return s2==null?s1:s2;
        if(s2==null || s2.isEmpty())return s1;
        if(s1.charAt(0)<s2.charAt(0))return s1.charAt(0)+merge(s1.substring(1),s2);
        else return s2.charAt(0)+merge(s1,s2.substring(1));
    }
}
