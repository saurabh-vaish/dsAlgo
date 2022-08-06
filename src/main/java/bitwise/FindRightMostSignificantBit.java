package bitwise;

/**
 * @Author saurabh vaish
 * @Date 04-08-2022
 */
public class FindRightMostSignificantBit {

    public static void main(String[] args) {

        int n = 12;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(-n));

        int rsb = n & (-n);   // to get right most digit
        System.out.println(rsb);
        System.out.println(Integer.toBinaryString(rsb));

        // now count the length
        int l = (int)(Math.log(rsb)/Math.log(2)) + 1;  // count the digits
        System.out.println(l);

        System.out.println((int)(Math.log(n&(-n))/Math.log(2)) + 1);  // 1 line ans

        System.out.println(method2(n));
    }

    private static int method2(int n){
        int c =1;
        while (n>0){
            if((n&1)==1)break;   // as soon as right most digit found break;
            c++;
            n=n>>1;  // drop bit
        }
        return c;
    }

}
