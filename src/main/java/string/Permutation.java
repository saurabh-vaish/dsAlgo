package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 16-8-2023
 */
public class Permutation {
    public static void main(String[] args) {
        String str="aac";
        List<String> result = new ArrayList<>();
        permuteStringWithoutDuplicatePermutation(str, "",result);
        System.out.println(result);
        List<String> result2 = new ArrayList<>();
        permuteStringWithDuplicatePermutation(str, "",result2);
        System.out.println(result2);
    }


    static List<String> permuteStringWithoutDuplicatePermutation(String str, String ans, List<String> result) {
        if (str.isEmpty()) {
            result.add(ans);
            return result;
        }

        // Make a boolean array of size '26' which stores false by default and make true at the position which alphabet is being used

        boolean chAr[] = new boolean[26];

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            // string accept current char
            String ros = str.substring(0, i) + str.substring(i + 1);

            // If the character has not been used then recursive call will take place. Otherwise, there will be no recursive call
            // if the char is not used then we will do recursive call , for this we will check with charArray
            if (!chAr[ch - 'a'])
                permuteStringWithoutDuplicatePermutation(ros, ans + ch,result);
            chAr[ch - 'a'] = true;
        }
        return result;
    }

    static List<String> permuteStringWithDuplicatePermutation(String str, String ans, List<String> result) {
        if (str.isEmpty()) {
            result.add(ans);
            return result;
        }

        for (int i = 0; i < str.length(); i++) {
            permuteStringWithDuplicatePermutation(str.substring(0,i)+str.substring(i+1,str.length()),
                    ans+str.charAt(i),result);
        }
        return result;
    }


}
