package bitwise;

/**
 * @Author saurabh vaish
 * @Date 06-08-2022
 */
public class CountDifferentBits {

    // program to count the different bits between two numbers
    // we need to find bits we are diff that we can find using xor as it will give 1 where bits are diff
    // then we just need to count 1's , i.e. similar to count set bits
    public static void main(String[] args) {

        int a=1, b = 8; // 2

        System.out.println(countSetBits(a,b));
    }

    private static int countSetBits(int a, int b) {
        int n = a ^ b;
        int c = 0;

        // O(1)
        while (n>0){
            c++;
            n=n & (n-1); //  it wil clear msb of bits and we need to iterate only no of bits time
        }

        // or
        // Complexity O(1) , (32) when bits are 32 bit
//        while (n>0){
//            if(n >> 1==1)c++; // count the set bits
//            n=n>>1;  // drop bits
//        }


        return c;
    }
}
