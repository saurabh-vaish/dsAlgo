package string;

import java.util.Arrays;

/**
 * Two words are anagrams of each other if they contain the same number of characters and the same characters.
 *
 * @Author saurabh vaish
 * @Date 16-08-2023
 */
public class AnagramString {
    public static void main(String[] args) {
        String str1 = "word",str="wrdo";
//        String str1 = "word",str="wrdi";
//        String str1 = "word",str="wwwer";

        System.out.println(checkUsingSort(str,str1));
        System.out.println(checkUsingArray(str,str1));
        System.out.println(checkUsingString(str,str1));

    }

    private static boolean checkUsingSort(String str, String str1) {
        if(str.length()!=str1.length())return false;
        char[] ch1 = str.toCharArray();
        char[] ch2 = str1.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }

    private static boolean checkUsingArray(String str, String str1) {
        if(str.length()!=str1.length())return false;

        int [] ch = new int[255];

        for(Character c:str1.toCharArray()){
            if(ch[c-'a']==0) {
                ch[c - 'a'] = c - 'a';
            }else{
                ch[c-'a']++;
            }
        }

        for(Character c:str.toCharArray()){
            if(ch[c-'a']==0){
                return false;
            }else{
                ch[c-'a']--;
            }
        }


        return true;
    }

    private static boolean checkUsingString(String str, String str1) {
        if(str.length()!=str1.length())return false;
        StringBuilder sb = new StringBuilder(str);

        for(Character c:str1.toCharArray()){
            int index = sb.indexOf(c+"");
            if(index!=-1){ // char exist
                sb.deleteCharAt(index);
            }else {
                return false;
            }
        }

        return sb.length()==0;
    }



}
