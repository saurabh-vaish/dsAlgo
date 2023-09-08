package array.ctci;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 *
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat'; "atco eta·; etc.)
 *
 * @Author saurabh vaish
 * @Date 03-07-2023
 */
public class CTCI_4_Palindrom_Permutation {

    // complexity == O(N) , space = O(1)
    // if a string to be palindrome then it will contain all even chars except one odd chars , and if an string has its permutation then we just need to check this property
    // we no need to gen all permutation of palindrome string
    private static boolean checkPalindromPermutation(String str) {
        int[] chars = new int[128]; // assuming ascii
        int countOdd = 0;
        for (int i = 0; i < str.length(); i++) {
            int ch = getCharNumber(str.charAt(i));
            if (ch != -1) {
                chars[ch]++;
                if ((chars[ch] & 1) == 1) { // check for odd
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }

        return countOdd <= 1;  // if odd chars are present more than one then its not a palindrome string .
    }


    /* Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
     * This is case insensitive. Non-letter characters map to -1. */
    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"};
        for (String s : strings) {
            boolean a = checkPalindromPermutation(s);
            boolean b = checkPalindromPermutation(s);
            boolean c = checkPalindromPermutation(s);
            System.out.println(s);
            if (a == b && b == c) {
                System.out.println("Agree: " + a);
            } else {
                System.out.println("Disagree: " + a + ", " + b + ", " + c);
            }
            System.out.println();
        }
    }

}
