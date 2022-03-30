package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Problem : Given a string s, partition s such that every substring of the it is a palindrome.
 * @Author saurabh vaish
 * @Date 31-03-2022
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> result = new ArrayList<>();
        partition(s, 0,new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void partition(String s, int start,List<String> sub, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start; i <s.length() ; i++) {
            if(isPalidrome(s, start, i)){
                sub.add(s.substring(start, i+1));
                partition(s, i+1, sub, result);
                sub.remove(sub.size()-1);
            }
        }
    }

    private static boolean isPalidrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) { // coming from start to end and checking if they are equal
                return false;
            }
        }
        return true;
    }
}
