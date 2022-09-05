package string;

/**
 * @Author saurabh vaish
 * @Date 18-08-2022
 */
public class RemoveWhiteSpace {

    public static void main(String[] args) {
        String s = "All  greek   to me.      ";

        System.out.println(removeWhiteSpace(s));

    }

    // O(N)
    private static String removeWhiteSpace(String s){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='\t' || s.charAt(i)==' '){
                String str=s.substring(0,i);
                int j=i;
                while (j<s.length() && s.charAt(j)==' ')++j;
                str+=s.substring(j);
                s=str;
            }
        }
        return s;
    }
}
