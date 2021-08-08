package recursion;

import java.util.stream.Stream;

/**
 * @Problem == Find the longest word in the string , ignore punctuations
 *
 * @Complexity - O(n)
 *
 * @author Saurabh Vaish
 * @Date 20-07-2021
 */
public class LongestWordInString {
    public static void main(String[] args) {
        String str = "The n@me id I$# someRandom#$ is intellij idea"; // someRandom
//        String str = "The n@me id I$# is intellij idea"; // intellij

        System.out.println("iterative solution = ");
        System.out.println(longestWordUsingIteration(str));

        System.out.println("streams solution = ");
        System.out.println(longestWordUsingStreams(str));

        System.out.println("recursive solution = ");

        String[] words = str.trim().split("[^\\w]");
        System.out.println(longestWordUsingRecursion(words,0,""));
    }

    private static String longestWordUsingStreams(String str) {
        return Stream.of(str.trim().split("[^\\w]")).reduce((s1,s2)->s1.length()>s2.length()?s1:s2).get();
    }

    private static String longestWordUsingIteration(String str) {
        String words [] = str.trim().split("[^\\w]");
        String longest="";
        for (String w:words){
            longest = w.length()>longest.length()?w:longest;
        }
        return longest;
    }

    private static String longestWordUsingRecursion(String[] words,int index,String longestWord) {
        if(words.length==index)return longestWord;
        longestWord = words[index].length()>longestWord.length()?words[index]:longestWord;
        return longestWordUsingRecursion(words,index+1,longestWord);
    }
}
