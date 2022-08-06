package bitwise;

/**
 * Program to check even odd using bitwise operator
 *
 * @Author saurabh vaish
 * @Date 31-07-2022
 */
public class CheckEvenOdd {

    public static void main(String[] args) {
        System.out.println(isOdd(12));
        System.out.println(isOdd(17));
        System.out.println(isOdd(5));
    }

    // if any numbers 2's place is 1 then it will be odd e.g. 17 == 10001
    // here lsb is 1 so its odd
    // so we just need to find the lsb is 1 or not
    // when we do and with 1 in any number it returns same
    // so a & 1 == a
    private static boolean isOdd(int n){
        return (n & 1)==1; // here n is being converted to binary then we are doing & 1 , 0 will get added before 1 as every odd no has 1 in lsb
                            // and we will get lsb as result so we are just checking that
                            // it will return true if number is odd
    }


}
