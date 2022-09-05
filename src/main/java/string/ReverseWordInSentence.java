package string;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author saurabh vaish
 * @Date 17-08-2022
 */
public class ReverseWordInSentence {

    public static void main(String[] args) {

        System.out.println(method1("The quick brown fox jumped over the lazy dog."));

        System.out.println(withoutUsingLibrary("The quick brown fox jumped over the lazy dog.".toCharArray()));
    }

    private static String method1(String text){
        String [] str = text.split(" ");

        String s="";
        for (int i = 0; i < str.length/2; i++) {
            String t = str[i];
            str[i]=str[str.length-i-1];
            str[str.length-i-1]=t;
        }
        return String.join(" ",str);

    }


    // O(N)
    private static String withoutUsingLibrary(char[] text){
        if(text.length==0)return "";

        inPlaceReverse(text,0,text.length-1);
        int start=0,end=0;

        while (true){
            if(start>= text.length-1){ // if it reaches to end
                break;
            }

            while (text[start]==' '){
                start++;
            }
            end=start+1;

            while (end< text.length && text[end]!=' ')end++;

            inPlaceReverse(text,start,end-1);
            start=end;
        }

        return String.valueOf(text);

    }

    private static void inPlaceReverse(char[] text,int start,int end){
        while (start<end){
            char temp = text[start];
            text[start]=text[end];
            text[end]=temp;
            start++;
            end--;
        }
    }


}
