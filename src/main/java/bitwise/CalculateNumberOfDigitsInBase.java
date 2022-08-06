package bitwise;

/**
 *  program to calculate number of digits in a given base
 *
 *  e.g. 12345 in base 10 == 5
 *  10 in base 2 = 4 [ 1010 ]
 *
 * @Author saurabh vaish
 * @Date 03-08-2022
 */
public class CalculateNumberOfDigitsInBase {

    public static void main(String[] args) {

//        int n = 12345;
//        int b = 10;
        int n = 10;
        int b = 2;

        // no of digits in base b of num n;
        int d = (int)(Math.log(n)/Math.log(b)) + 1;  // no of times the digit can be written in log by base b + 1
        System.out.println(d);

    }

}
