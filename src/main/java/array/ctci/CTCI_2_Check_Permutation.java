package array.ctci;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 *
 * @Author saurabh vaish
 * @Date 30-06-2023
 */
public class CTCI_2_Check_Permutation {

    // not efficient
    // Comp = O( n log n) + O(n log n) , logn for sorting
    // In this approach , will sort both strings and check both are same , if not then string is not in permutation
    private static boolean check_permutation_basic(String s1,String s2){
        if(s1.length() != s2.length()) return false;  // as if they are in permutation then length should be same

        return sort(s1).equals(sort(s2));   // after sorting both string shoild be same

    }

   private static String sort(String s){
        char [] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }


    // Comp = O( len of string )  [ both ]
    // In this approach , as one string is permutation of another so there char count must be same
    private static boolean check_permutation_optimal(String s1,String s2){
        if(s1.length() != s2.length()) return false;  // as if they are in permutation then length should be same

        int [] ar = new int[128] ; // considering ascii chars

        for(int i=0;i<s1.length();i++){
            ar[s1.charAt(i)]++;            // storing the count
        }

        for(int i=0;i<s2.length();i++){
            ar[s2.charAt(i)]--;     // reducing count from ar using second string

            if(ar[s2.charAt(i)]<0)return false;  // if any string is not there in ar then it will be less
        }

        return true;
    }


    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = check_permutation_basic(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);

            boolean anagram2 = check_permutation_optimal(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram2);
        }
    }


}
