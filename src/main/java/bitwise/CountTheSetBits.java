package bitwise;

/**
 * @Author saurabh vaish
 * @Date 03-08-2022
 */
public class CountTheSetBits {

    // program to count the set bits in a number
    // set bits are the bit which are 1
    public static void main(String[] args) {

        int n = 156;

        System.out.println(method1(n));
        System.out.println(method2(n));

        System.out.println(Integer.bitCount(n));
    }


    // n-1 of a number is 1 bit less so when we subtract it from n we will get that 1 bit
    // we need to keep check until it becomes 0
    // Complexity == no of set bits
    private static int method1(int n) {
        int count=0;
        while (n>0){
            count++;
            n = n & (n -1 );
        }
        return count;
    }


    // get lsb check its 1 then increase counter
    // drop bit
    // Complexity - log(n)
    private static int method2(int n) {
        int c=0;
        while (n>0){
            int l = n&1; // getting lsb
            if(l==1)c++;  // if its 1 then increase counter as its set bit
            n=n>>1;   // drop bit
        }
        return c;
    }
}
