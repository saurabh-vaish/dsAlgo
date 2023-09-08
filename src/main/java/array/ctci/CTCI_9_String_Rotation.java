package array.ctci;

/**
 * : Assume you have a method i 5Su b 5 tr ing which checks if one word is a substring of another. Given two strings,
 * s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 *
 * @Author saurabh vaish
 * @Date 05-07-2023
 */
public class CTCI_9_String_Rotation {

    // comp - O(n)
    // we can check 1 string is rotation of other ,as rotation is done by shifting the chars from string ,
    // so if we make our string bigger by adding same string then by calling substring once only we can verify it
    private static boolean isRotation(String s1,String s2){

        if(s2.length()>s1.length())return false;

        String s1s1 = s1+s1;

        return isSubString(s1s1,s2);

    }

    private static boolean isSubString(String s1s1,String s2){
        return s1s1.contains(s2);
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"},{"abac","baca"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
