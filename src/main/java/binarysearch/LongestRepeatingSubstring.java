package binarysearch;

import java.util.HashSet;
import java.util.Set;

/**
 * @Problem == Given a string S, find out the length of the longest repeating substring(s). Return 0 if no repeating substring exists.
 *
 * @Solution == if we have a repeating substring of length M, that would also mean that we have repeating substring of length K, where K < M.
 *              Using this observation, our problem reduces to finding the substring of longest length that has more than 1 occurrences in the given string.
 *              With the advanced binary search "finding the MAXIMUM value in the search space that satisfies certain condition".
 *              In our case, search space is [0, length of given string] and condition is number of occurrences of the substring >= 2.
 *
 *              If substring of length mid does not satisfy our condition, no substring of length greater than mid would satisfy the condition either.
 *              So we need to search for substring with length less than mid. So we move more towards the left of the search space to access the values lower than mid.
 *              We achieve this by contracting our search space appropriately by doing  right = mid;.
 *
 *              If we get a substring of length mid satisfies our solution, we would look for if there is any other substring of length greater than mid that also satisfies our condition.
 *              We achieve this by moving more towards right so that we can access the higher values (values which are greater than mid in the search space) in the search space.
 *              We achieve this by contracting search space appropriately by doing  left = mid + 1;
 *
 *
 * @Complexity ==
 *
 *
 * @author Saurabh Vaish
 * @Date 02-06-2021
 */
public class LongestRepeatingSubstring {

    public static void main(String[] args) {
        int len1 = getLongestSubstring("aabcaabdaab");
        System.out.println("length of substring = "+len1);
        int len2 = getLongestSubstring("abbaba");
        System.out.println("length of substring = "+len2);
        int len3 = getLongestSubstring("aaaaa");
        System.out.println("length of substring = "+len3);
        int len4 = getLongestSubstring("abcd");
        System.out.println("length of substring = "+len4);
    }

    private static int getLongestSubstring(String str) {
        int len=str.length();
        int left=0;
        int right=len;
        int startIndex=0;
        while (left<right){
            int mid = (left+right)/2;
            int index = searchSubString(str,mid,len);  // returns index if any repeated substring found
            if(index!=-1){              // if substring within mid length search space found
                startIndex=index;   // need to search in right part
                left=mid+1;
            }else{
                right=mid;  // if substring of mid length not found then there will be no substring greater than mid so , decrease our search space and search in left part
            }
        }
        System.out.println("longest substring == "+str.substring(startIndex,startIndex+(left-1)));
        return left-1;
    }


    /*
    Search a substring of given length
    that occurs at least 2 times.
    Return start position if the substring exits and -1 otherwise.
    */
    private static int searchSubString(String str, int mid, int len) {
        Set<String> subs= new HashSet<>();
        for(int start=0;start<len-mid+1; start++){
            String s = str.substring(start,start+mid );
            // keep all substrings of length = length in hashset as you go
            // you know there is repeating substring of length = length
            // if you encounter a substring that already exists in the hash set
            if(subs.contains(s)){
                return start;
            }
            subs.add(s);  // we can optimize space by using hashcode i.e. s.hashCode();
        }
        return -1;
    }
}
