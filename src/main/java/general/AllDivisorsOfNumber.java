package general;

import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 30-08-2022
 */
public class AllDivisorsOfNumber {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(divisors(n));
        System.out.println(sumOfDivisors(n));
    }

    static long sumOfDivisors(int n){
        // code here
        long sum=1;

        for(int i=2;i<=n;i++){
            sum+=f(i);
        }
        return sum;

    }

    static int f(int n){
        int sum=0;
        for(int i=1;i<=(int)Math.sqrt(n);i++){
            sum+=n%i==0?i:0;
        }
        return sum+n;
    }

    static String divisors(int n){
        String s="";
        String r="";
        for (int i = 1; i <= (int)Math.sqrt(n); i++) {
            if(n%i==0){
                s+=i + " ";
                r=n/i+" "+r;
            }
        }
        return s+r;
    }
}
