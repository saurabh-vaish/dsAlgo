package string;

public class MaxRepeatedCharsInString {
    public static void main(String[] args) {

//        String str = "aabbbccccddde";
        String str = "aabbbcccccddddeeeeeeefffff";
        int max = 0;
        int ar[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            ar[c-'a']++;
            max = Math.max(max, ar[c-'a']);
        }
        System.out.println(max);

    }
}
