package recursion;

/**
 * @Author saurabh vaish
 * @Date 14-08-2022
 */
public class StringRemoveDuplicateAdjacent {

    public static void main(String[] args) {
        System.out.println(removeDuplicate("Hello World"));
    }

    // O(length)
    private static String removeDuplicate(String str){
        if(str.length()==1)return str;
//        if(str.substring(0,1).equals(str.substring(1,2)))return removeDuplicate(str.substring(1));
        if(str.charAt(0)==str.charAt(1))return removeDuplicate(str.substring(1));
        return str.charAt(0)+removeDuplicate(str.substring(1));
    }
}
