package recursion;

/***
 *  Example of check string is palindrom or not using recursion
 *  Time complexity == O(n/2)
 *  Space complexity == O(n/2)
 * 
 */
public class CheckPalindrom {
    public static void main(String[] args) {

        String str = "madaM";

        System.out.println("is palindrom " + checkPalindrom(0,str.length()-1,str.toLowerCase()));
    }

    // using two params
    private static boolean checkPalindrom(int left,int right, String str) {
        if (left > right) {
            return true;
        }
       
        if(str.charAt(left) != str.charAt(right)) {
            return false;
        }

        return checkPalindrom(left + 1,right-1,str); // in each steps we are increasing left by 1 and decreasing right by 1
    }


}