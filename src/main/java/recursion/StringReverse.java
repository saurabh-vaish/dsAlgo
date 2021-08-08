package recursion;

/**
 * @author Saurabh Vaish
 * @Date 20-07-2021
 */
public class StringReverse {
    public static void main(String[] args) {
        String str = "reverse string";
        System.out.println("iterative solution = ");
        System.out.println(stringReverseUsingIteration(str));

        System.out.println("streams solution = ");
        System.out.println(stringReverseUsingReverseMethod(str));

        System.out.println("recursive solution = ");
        System.out.println(stringReverseUsingRecursion(str,""));
    }

    private static String stringReverseUsingReverseMethod(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    private static String stringReverseUsingIteration(String str) {
        StringBuilder s= new StringBuilder();
        for (int i=str.length()-1;i>=0;i--){
            s.append(str.charAt(i));
        }
        return s.toString();
    }

    private static String stringReverseUsingRecursion(String str,String stringReverse) {
        if(str.length()==0)
            return stringReverse;
        stringReverse+=stringReverseUsingRecursion(str.substring(1),stringReverse)+str.substring(0, 1);
        return stringReverse;
    }
}
