package bitwise;

/**
 * Program to find the nth magic number here magic number is
 *  -- start from 1 convert to binary and do the power of 5 then give sum
 *
 * @Author saurabh vaish
 * @Date 03-08-2022
 */
public class FindNthMagicNumber {

    public static void main(String[] args) {
        // n number of times
        // k is the base
        System.out.println(magicNumber(6,5));
    }

    // here magic number is convert every number from 1 to n to binary then add them by power of k
    // first we will get the last bit of binary that we can get by & with 1 i.e. n & 1;
    // then multiply by k to this last digit
    // then increase base by k times as as base power raises as it goes to msb
    // then in last drop the bit that already calculated
    // complexity == log(n)  , why the loop will run untill n becomes zero i.e. no of bits in n
    private static int magicNumber(int n,int k){
        int sum=0;
        int base = k;
        while (n>0){
            int last= n & 1;            // getting last bit
            sum += last * base;         // multiple by k to last then add to ans
            base=base * k;              // increase base
            n = n>>1;                   // dropping bit using right shift
        }
        return sum;
    }

}
