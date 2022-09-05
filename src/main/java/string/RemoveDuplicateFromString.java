package string;

/**
 * @Author saurabh vaish
 * @Date 18-08-2022
 */
public class RemoveDuplicateFromString {

    public static void main(String[] args) {
        String s="ssssdDAddasfdfFfffffdseeert";

        System.out.println(remove(s));

        System.out.println(removeApproach2(s));
    }

    // O(N), O(256)
    private static String remove(String str){
        boolean [] ar = new boolean[256]; // ASCII values
        String s="";
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if(!ar[ch-'a']){
                s+=ch;
            }
            ar[ch-'a']=true;
        }
        return s;
    }

    // O(N), O(1)
    private static String removeApproach2(String str){
        String s="";
        for (int i = 0; i < str.length(); i++) {
            if(s.toLowerCase().indexOf(str.toLowerCase().charAt(i))<0){
                s+=str.charAt(i);
            }
        }
        return s;
    }
}
