package general;

import java.util.HashMap;
import java.util.Map;

/**
 *  Hashing -- hashing is useful when we have to count digits or chars , we need to create hash function properly
 *
 *
 *
 *
 *
 * @Author saurabh vaish
 * @Date 29-01-2023
 */
public class Hashing {

    public static void main(String[] args) {
        System.out.println("no of digits brute ");

        int ar[] = countDigitsInNumberUsingArray(324424);

        for (int i = 1; i < ar.length; i++) {
            if(ar[i]!=0){
                System.out.println(i+" == "+ar[i]);
            }
        }

        System.out.println("no of digits using hashing = "+countDigitsInNumberHashing(324424));

        int chr [] = countCharsUsingArray("aabccddeefhrrd");
        System.out.println("no of chars in string using array = ");

        for (int i = 0; i < chr.length; i++) {
            if(chr[i]!=0){
                System.out.println((char)(i+'a') +" == "+chr[i]);
            }
        }

//        int chr [] = countCharsUsingArray("AaAccddEefHRrd");
//        System.out.println("no of chars in string using array = ");
//
//        for (int i = 0; i < chr.length; i++) {
//            if(chr[i]!=0){
//                System.out.println((char)(i) +" == "+chr[i]);
//            }
//        }


    }

    // the basic method to get count , but the problem in this approach as we need to declare n+1 size array
    // and after certain it will cross data type range and worst as space comp
    // comp == O(log (n))   log10 n as we are dividing by 10 each time, O(n) space
    private static int[] countDigitsInNumberUsingArray(int d){

        int ar[] = new int[d+1]; // no need to fill the array assuming digit will not contain 0

        while (d>0){
            ar[d%10]++;  // increasing count
            d=d/10;
        }
        return ar;
    }

    // using hashing we can reduce space complexity , but the problem ans will be in sorted form not in as in digits
    // to maintain order we can use LinkedHashMap that can have O(N) worst case
    // comp --  O(log (n)) + O(1) [ for hashmap O(log(n)) worst ]
    private static Map<Integer,Integer> countDigitsInNumberHashing(int d){

        Map<Integer,Integer> map = new HashMap<>();

        while (d>0){
            int rem = d%10;
            map.putIfAbsent(rem,1);
            map.computeIfPresent(rem,(r,v)->map.get(r)+1);
            d=d/10;
        }
        return map;
    }


    // the basic method to get count of chars using array with the help of ascii
    // since every char has some ascii value so we can convert them to int array
    // we can have at max 256 chars including capital and small both
    // if we have only lowercase then we can store them by subtracting from 'a'
    // complexity - O( len (str))
    private static int[] countCharsUsingArray(String str){

        char ch[] = str.toCharArray();

        int ar[] = new int[26]; // as max chars are 26 only and assuming all are in lowercase , and they will get convert to int

        for (int i = 0; i < ch.length; i++) {
            int charPosition = ch[i]-'a';  // we are subtracting from a as to get in 26 length range
            ar[charPosition]++;
        }

//        int ar[] = new int[256]; // as per ascii only 256 chars are including upper and lower case
//
//        for (int i = 0; i < ch.length; i++) {
//            ar[ch[i]]++;
//        }

        return ar;
    }


}
