package general;

/**
 * @Author saurabh vaish
 * @Date 30-08-2022
 */
public class CountTheNumberOfDigits {
    public static void main(String[] args) {
        int n = 10000;

        System.out.println(usingLoop(n));
        System.out.println(usingToString(n));
        System.out.println(usingLog(n));
    }

    // O(N) , O(1)
    private static int usingLoop(int n) {
        int count=0;
        while (n>0){
            n/=10;
            count++;
        }
        return count;
    }

    // O(1) both
    private static int usingToString(int n) {
        return Integer.toString(n).length();
    }

    // O(1) both
    // log10(N)  returns the base 10 logarithm of a double value , if the argument is equal to 10n for integer n, then the result is n
    // it represents number in power of 10
    // adding 1 bcs need to count 1 also
    // taking floor as double value and making it to int
    private static int usingLog(int n) {
        return (int)Math.floor(Math.log10(n)+1);
    }


}
