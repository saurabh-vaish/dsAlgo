package general;

import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 17-08-2022
 */
public class Prime {

    public static void main(String[] args) {
        System.out.println(checkPrime(2));
        System.out.println(checkPrime(3));
        System.out.println(checkPrime(32));
        System.out.println(checkPrime(325));
        System.out.println(checkPrime(11));
        System.out.println(checkPrime(117));
        System.out.println(checkPrime(61));

        System.out.println(Arrays.toString(checkPrimeTillNum(40)));

        System.out.println(Arrays.toString(checkPrimeInRange(10,40)));
    }

    // O(sqrt of num) , O(1)
    private static boolean checkPrime(int num){
        for (int i = 2; i*i <=num ; i++) {
            if(num%i==0)return false;
        }
        return true;
    }


    // sieve method to check prime in range
    // complexity - O( n * log(log(n)))
    private static int[] checkPrimeTillNum(int n){
        int[] ar = new int[n];
        boolean [] temp = new boolean[n+1]; // will consider false as prime

        for (int i = 2; i*i <=n ; i++) { // will go for sqrt only as for prime of n we will go till sqrt(n) , so all other will get prime less than sqrt(n)
            if(!temp[i]) {
                for (int j = i*2; j <= n; j+=i) { // we are adding the digit untill its reaching to n as we want to remove all factors of i
                    temp[j]=true;
                }
            }
        }

        int k=0;
        for (int i = 2; i <= n; i++) {
            if(!temp[i]){ // will get prime which are false
                ar[k++]=i;
            }
        }

        return ar;
    }

    private static int[] checkPrimeInRange(int n1, int n2){
        int[] ar = new int[Math.abs(n2-n1)];
        int k=0;
        for (int i = n1; i <=n2 ; i++) {
            if(checkPrime(i)){
                ar[k++]=i;
            }
        }

        return ar;
    }



}
