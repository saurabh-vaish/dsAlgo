package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * https://www.codingninjas.com/studio/problems/sort-array-of-strings_1215011
 *
 * sort array of string based on order char
 *
 * @Author saurabh vaish
 * @Date 08-09-2023
 */
public class SortArrayOfStrings {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("please accept my offer".split(" ")));
        char c = 'd';

        Map<Character,Integer> map = createOrderMap(c);

        System.out.println(sort(list,c,map));
    }

    private static Map<Character, Integer> createOrderMap(char c) {
        Map<Character,Integer> map = new HashMap<>();
        int k=0;
        for (int i = 0; i <= 26-(c-'a'); i++) {
            map.put((char) (c+i),k++);
        }
        for(int i='a';i<c;i++){
            map.put(((char)i),k++);
        }

        return map;
    }

    private static ArrayList<String> sort(ArrayList<String> list, char c, Map<Character, Integer> map) {
        return list.stream().sorted((s1,s2)->compare(s1,s2,map)).collect(Collectors.toCollection(()->new ArrayList<>()));
    }

    private static int compare(String s1, String s2, Map<Character, Integer> map) {
        for (int i = 0; i < Math.min(s1.length(),s2.length()); i++) {
            if(map.get(s1.charAt(i))!=map.get(s2.charAt(i))){
                return map.get(s1.charAt(i))-map.get(s2.charAt(i));
            }
        }

        return s1.length()-s2.length();
    }
}
