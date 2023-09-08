package array.ctci;

/**
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 *
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 *
 * @Author saurabh vaish
 * @Date 03-07-2023
 */
public class CTCI_5_OneAway {

    // O(n)
    // since we need to check that we need to do only one modification then
    private static boolean oneEditAway(String s1,String s2){
        boolean oneEdit = false;
        if(Math.abs(s1.length()-s2.length())>1)return false;  //as there are only one modification so length diff should not be greater than 1

        String smallStr = s1.length() < s2.length()?s1:s2;
        String largeStr = s1.length() < s2.length()?s2:s1;

        int index1=0;  // for small string
        int index2=0; // for large string

        while(index1 < smallStr.length() && index2 < largeStr.length() ){
            if(smallStr.charAt(index1)!=largeStr.charAt(index2)){
                if(oneEdit)return false;  // as already one edit has been counted
                oneEdit = true;

                if(s1.length() == s2.length()){
                    index1++;  // as both string length is same , but char is not same , so need to replace it , then increase small string pointer
                }
                index2++;
            }else{
                // chars are same so increase both indexes
                index1++;
                index2++;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }
    }

    public static void test(String a, String b, boolean expected) {
        boolean resultA = oneEditAway(a, b);
        boolean resultB = oneEditAway(a, b);

        if (resultA == expected && resultB == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }
}
