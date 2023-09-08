package string;

import java.util.*;

/**
 * @Author saurabh vaish
 * @Date 16-08-2023
 */
public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String str = "swiss";
//        String str = "aaaa";

        System.out.println(fistNonRepUsingMap(str));
        System.out.println(fistNonRepUsingArray(str));
        System.out.println(fistNonRepUsingList(str));
    }

    private static Character fistNonRepUsingMap(String str) {
        Map<Character,Integer> map = new LinkedHashMap<>();

        for (Character ch:str.toCharArray()){
            map.computeIfPresent(ch,(k,v)->v+1);
            map.putIfAbsent(ch,1);
        }

        for (Map.Entry<Character,Integer> e :map.entrySet()){
            if(e.getValue()==1)return  e.getKey();
        }

        throw new IllegalArgumentException("No unique char present");
    }


    private static Character fistNonRepUsingArray(String str) {
        int[] arr = new int[255];

        for (Character ch:str.toCharArray()){
            arr[ch-'a']++;
        }
        for (Character ch:str.toCharArray()){
            if(arr[ch-'a']==1)return ch;
        }

        throw new IllegalArgumentException("No unique char present");
    }

    private static Character fistNonRepUsingList(String str) {
        Set<Character> set = new HashSet<>();
        List<Character> list = new LinkedList<>();

        for (Character ch:str.toCharArray()){
            if(set.contains(ch)){
                continue;
            }else{
                if(list.contains(ch)){
                    list.remove(ch);
                    set.add(ch);
                }else {
                    list.add(ch);
                }
            }
        }
        return list.get(0);

//        throw new IllegalArgumentException("No unique char present");
    }



}
