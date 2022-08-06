package bitwise;

/**
 * @Author saurabh vaish
 * @Date 03-08-2022
 */
public class PowerOfBaseAtoB {

    // complexity -- log(n)
    // program to get power of number a to power b
    public static void main(String[] args) {
        int base = 3;
        int power = 6;  // or 4 + 2 + 0 or  binary == 110

        int ans = 1;
        while (power>0){               // untill all bits are not dropped
            if((power & 1)==1){     // when bit is only 1 then only add , will consider only set bits
                ans = ans * base;   // adding base to ans
            }
            base = base * base;   // multiplying base to base as when we got lsb to msb base power raises
            power = power>>1;  // shifting right to drop bit
        }

        System.out.println(ans);

    }
}
