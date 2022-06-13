package ninja;

import java.math.BigInteger;

/**
 *
 * @Link  = https://www.codingninjas.com/codestudio/problems/square-root-integral_893351?leftPanelTab=0
 *
 * @Problem  =
 *
 *
 * @Author saurabh vaish
 * @Date 11-06-2022
 */
public class SquareRootWithoutFunction {

    public static void main(String[] args) {

        int n=10090000;
//        int n=16;

        System.out.println(sqrtUsingBinary(n));
        System.out.println(sqrtOptimizedForLargeNumbers(n));
    }

    // time - O(log(x))
    private static int sqrtUsingBinary(int n) {
        long start = 0;
         long end = n;
         long result=0;
         while(start<=end){
             long mid = start + (end-start)/2;
             long re= mid*mid;
             if(re==n)return (int)mid;
             else if(re<n){
                 start = mid+1;
                 result = mid;
             }else {
                 end = mid-1;
             }
         }
         return (int) result;
    }

    // Time - O(log(r))
    private static int sqrtOptimizedForLargeNumbers(long n){
        if(n==0)return 0;
        if(n<=2)return 1;

        // newtons method
        BigInteger r = BigInteger.valueOf(n);
        BigInteger num = r;

        while (r.multiply(r).compareTo(num) > 0){
            r = (r.add(num.divide(r))).divide(BigInteger.valueOf(2));
        }

        return r.intValue();

//        long r = n;
//        while(r*r>n){
//            r = (r+r/n)/2;
//        }
//        return (int)r;
    }

}
