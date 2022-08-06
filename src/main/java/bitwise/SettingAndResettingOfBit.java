package bitwise;

/**
 * This is program to set and reset bit
 *
 *  Bit Setting == setting a bit means if a bit in ith place is 0 make 1 it 1 keep 1 only
 *
 * @Author saurabh vaish
 * @Date 01-08-2022
 */
public class SettingAndResettingOfBit {

    public static void main(String[] args) {
        // 17 == 10001
        System.out.println(setBit(17,1));  // 17 no effect we are setting 1st bit that is already one
        System.out.println(setBit(17,3));  // 10001  == 10101       // 3rd 0 so set to 1
        System.out.println(resetBit(17,1));  // 10001 == 10000      // 1st is 1 so gets reseted
        System.out.println(resetBit(17,3));  // 10001 == 10001      // since 3rd already 0
        System.out.println(toggleBit(17,3));  // 10001 == 10101      // since toggled 3rd bit
        System.out.println(checkSetBit(setBit(17,3),3));  // true as 3rd place bit got set 1001 ==> 10101 ==> 101 & 1 == 1
        System.out.println(checkSetBit(resetBit(setBit(17,3),3),3));  // true as 3rd place bit got set then reset then check 1001 ==> 10101 ==> 10001 ==> 100 & 1 !=1

    }

    private static int setBit(int num,int k){  // if kth place 0 make 1
        return num | (1 << k-1); // getting masked number till k then doing OR so that only kth bit will change if its 0
    }

    private static int resetBit(int num,int k){ // if kth place 1 make 0
        return num & (~(1 << k-1)); // get masked number then complement so that we have kth digit 0 rest all 1 then do and so that only kth bit gets resets
    }

    private static int toggleBit(int num,int k){ // if kth place 1 make 0 if 0 make 1
        return num ^ (1 << k-1); // get masked number then do XOR with num then we will get number except for that particular kth bit
    }

    private static boolean checkSetBit(int bit,int k){ // if kth place is 1 then bit is set
        return ((bit >> k-1) & 1) == 1; // drop all extra bit till kth in bitnum then do and with 1 to check lsb is 1 or not , if 1 then bit is set
    }





}
