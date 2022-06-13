package ninja;

/**
 * @Link = https://www.codingninjas.com/codestudio/library/check-if-a-number-is-not-a-power-of-2
 *
 * @Problem = Suppose you have given a number ‘N’. You have to find out if it is a power of 2 or not. (Print ‘YES’ if ‘N’ is a power of 2, otherwise ‘NO’).
 *
 * @Author saurabh vaish
 * @Date 11-06-2022
 */
public class CheckPowerOf2 {

    public static void main(String[] args) {
        int n = 4;

        System.out.println(approach1(n));
        System.out.println(approach2(n));
        System.out.println(approach3(n));
        System.out.println(approach4(n));
    }


    // bruteforce solution
    // Time - O(log(n))  // as we are dividing / 2 on each step
    //  space - O(1)
    private static boolean approach1(int n) {
        if(n==0)return false;

        while (n%2==0)n/=2;

        return n==1;  // if n become 1 means power of 2
    }


    // using recursion
    // time - O(log(n))
    // space - O(log(n))
    private static boolean approach2(int n) {
        if(n==1)return true;
        if(n== 0 || n%2!=0)return false;

        return approach2(n/2);
    }


    // using log base 2 as log2(1024) == 10 i.e. 10 time 2 is 1024 or 2^10
    // time - O(1)
    // space - O(1)
    private static boolean approach3(int n) {
        if(n==0)return false;
        // as there is no log base 2 in java
        // as we know loga b = loge b / loge a ,  so   log2 N = loge N / loge 2
        double logg = Math.log(n) / Math.log(2);
        return Math.floor(logg) == Math.ceil(logg); // if floor and ceil values are same then true
    }


      /*   using binary representation
         as
        N = 2 = 21 = 00. . .000001
        N = 8 = 23 = 00. . .001000
        N = 32 = 25 = 00. . .100000

        We can observe that all numbers which are a power of 2 have only one set bit. Can you use this idea to implement the solution?

        The idea is the count the number of set bits. If the number of set bits is 1, ‘N’ is a power of 2; otherwise not.

         time - O(1) // The loop is terminated here as soon as the second set bit is encountered.
         space - O(1)

       */
    private static boolean approach4(int n) {
        if(n==0)return false;
//
//        int count=0;
//        while(n>0){
//            n &=n-1;
//            count++;
//
//            if(count>1)return false;
//        }
//        return true;

        return (n & n-1)==0;
        // checks if bitwise & of number ‘N’ with ‘N - 1’ returns 0 as  the numbers which are a power of 2 has only one set bit.
        // We can simply unset the last bit and see if the number reduces to zero. If yes, then the number is a power of 2; otherwise not.
    }
}
