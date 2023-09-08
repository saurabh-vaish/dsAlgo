package array.ctci;

/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z)
 *
 * @Author saurabh vaish
 * @Date 06-07-2023
 */
public class CTCI_6_StringCompresstion {

    private static String compress(String str){
        StringBuilder sb = new StringBuilder();
        int count=0;

        for(int i=0;i<str.length();i++){
            count++;  // counting char

            // if char is not then add count to char
            if(i+1>=str.length() || str.charAt(i)!=str.charAt(i+1)){
                sb.append(str.charAt(i));
                sb.append(count);

                count=0; // making count 0 again for next chars
            }
        }


        return sb.length()<str.length()?sb.toString():str;  // sending smaller string
    }


    public static void main(String[] args) {
        String str = "aaaaabbbbaaaabbddc";
        String str1 = "aa";
        System.out.println(compress(str));
        System.out.println(compress(str1));
    }
}
