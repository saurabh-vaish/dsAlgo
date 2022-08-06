package bitwise;

/**
 * Program to find the nth bit of a number
 *
 * @Author saurabh vaish
 * @Date 01-08-2022
 */
public class FindNthBit {

    public static void main(String[] args) {
        System.out.println(findBit1(5,17));
        System.out.println(findBit1(3,17));
        System.out.println(findBit2(5,17));
        System.out.println(findBit2(3,17));
    }

    // first find the masked number of the num by doing left shift 1 to k-1 times , will add zero after 1
    // do and with masked number so that we have only kth bit decimal
    // now do right shift till k-1 to drop all bits except kth
    private static int findBit1(int k, int num){
//        return num & (1<<(k-1));  // will return in decimal but we need bit
        return (num & (1<<(k-1)))  >> (k-1); // after getting decimal right shift untill no k-1

    }

    // easier sol and optimal
    // right shift number to k-1 times to drop all bits except kth
    // now we only need to check if lsb its 1 or 0 that we can get either by %2 or & 1
    // here we are doing with masked 1 so only lsb remains else got 0
    private static int findBit2(int k, int num){

        return ((num >> (k-1)) & 1);
    }


}
