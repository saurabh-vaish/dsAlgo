package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Saurabh Vaish
 * @Date 20-07-2021
 */
public class Permutation {
    public static void main(String[] args) {
        String str="abc";
        List<String> result = new ArrayList<>();
//        permute(str,result);
        permuteString(str, "",result);
        System.out.println(result);
    }

//    private static List<String> permute(String str, List<String> result) {
//        if(str.length()==0){
//            result.add(str);
//            return result;
//        }
//        char first=str.charAt(0);
//        List<String> partial = permute(str.substring(1), result);
//        partial.forEach(s->{
//            for (int i = 0; i < s.length(); i++) {
//
//            }
//        });
//    }

    static List<String> permuteString(String str, String ans, List<String> result) {
        if (str.length() == 0) {
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
                permuteString(ros, ans + ch,result);
            chAr[ch - 'a'] = true;
        }
        return result;
    }

}
