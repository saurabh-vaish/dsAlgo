package recursion;

/**
 * @Author saurabh vaish
 * @Date 14-08-2022
 */
public class CheckPrime {

    public static void main( String args[] ) {
        int input = 12;
        boolean result = isPrime(input, input/2);
        System.out.println(result);

        System.out.println(isPrime2(input,2));
    }

    // complexity = O(n/2)
    public static boolean isPrime(int num, int i) {
        if (num < 2) {
            return false;
        } else if (i == 1) {
            return true;
        } else if (num % i == 0) {
            return false;
        }

        return isPrime(num, i - 1);
    }

    // complexity = O(n/2)
    private static boolean isPrime2(int num,int i){
        if(num==2)return true;
        if(num%i==0)return false;
        if(i>(num/2))return true;
        return isPrime(num,i+1);
    }
}
