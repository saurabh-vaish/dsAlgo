package string;

import java.util.HashMap;
import java.util.Map;

public class MaxRepeatedCharsInString {


    // program to max count the times a char is repeated
    public static void main(String[] args) {

//        String str = "aabbbccccddde";
        String str = "aabbbcccccdddddddeeeeeeefffff";
        int max = optimized(str);
        System.out.println(max);


        System.out.println(usingMap(str));

    }

    // O(n) , O(1)
    private static int optimized(String str) {
        int max = 0;
        int ar[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            ar[c-'a']++; // ar[c-'a'] so that we can get proper index
            max = Math.max(max, ar[c-'a']);
        }
        return max;
    }

    // O(n) both , as we are creating extra map
    private static int usingMap(String str){
        if(str.isEmpty())return 0;
        if(str.length()==1)return 1;
        Map<Character,Integer> map = new HashMap<>();
        int max=0;
        for (int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
//                max=1;
            }else{
                Integer c = map.get(str.charAt(i));
                int ins=++c;
                map.put(str.charAt(i),ins);
                max=Math.max(max,ins);
            }
        }

        return max;

    }

}
