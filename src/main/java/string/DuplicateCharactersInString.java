package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author saurabh vaish
 * @Date 16-08-2023
 */
public class DuplicateCharactersInString {

    public static void main(String[] args) {
        String str = "Programming";

        duplicate(str);

        duplicateWithCount(str);

    }

    private static void duplicateWithCount(String str) {
        if(str==null || str.isEmpty())throw new IllegalArgumentException("String is empty");
        HashMap<Character,Integer> map = new HashMap<>();
        for (Character ch:str.toCharArray()){
            map.computeIfPresent(ch,(k,v)->v+1);
            map.putIfAbsent(ch,1);
        }

        map.forEach((k,v)-> {
            if(v>1) System.out.println(k+"="+v);
        });
    }

    private static void duplicate(String str) {
        if(str==null || str.isEmpty())throw new IllegalArgumentException("String is empty");
        Set<Character> set = new HashSet<>();
        for(Character ch:str.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
            }else{
                System.out.println(ch);
            }
        }
    }
}
