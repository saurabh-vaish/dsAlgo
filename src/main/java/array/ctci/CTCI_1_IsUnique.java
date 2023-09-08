package array.ctci;

/**
 *  Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 *
 *
 *
 * @Author saurabh vaish
 * @Date 30-06-2023
 */
public class CTCI_1_IsUnique {


    // Comp = O(n)   [ both ]
    // In this approach we will take an array to store the chars ans then check if they are
    // will store all the chars in array and check if they exist already or not
    private static boolean isUnique_basic(String str){
        // assume all chars are ASCII

        if(str.length() > 128 )return false;  // as all are ascii so length will not be more than 128

        boolean [] chars = new boolean[128];  // including alphabets , numbers and some special chars

        for(int i=0;i<str.length();i++){
            int ch = str.charAt(i);
            if(chars[ch])return false;
            chars[ch]=true;
        }

        return true;
    }


    // Comp = O(n)  , space = O(1)
    // in this approach will take one variable and will do bit manipulation on that .
    // In this approach will assume only lowercase letters , so will take range from a to z
    // will take int value of chars then will shift bit by those value
    // then will do & with variable, if result is greater than 0 then duplicate chars exist
    // then update variable by doing or with char value
    private static boolean isUnique_optional_without_space(String str){
        // assume all chars are ASCII

        if(str.length() > 26 )return false;  // as we are considering only lowercase chars

       int checker = 0;

       for(int i=0;i<str.length();i++){
           int val = str.charAt(i) - 'a';

           int shifted_bit = (1 << val);

           if((checker & shifted_bit) > 0){
               return false;
           }
           checker = checker | shifted_bit;
       }

       return true;
    }



    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};

        for (String word : words) {
            System.out.println(word + ": " + isUnique_basic(word));
            System.out.println(word + ": " + isUnique_optional_without_space(word));
        }

    }

}
