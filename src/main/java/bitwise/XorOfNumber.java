package bitwise;

/**
 *  number a   |     XOR from  0 to a
 *  0                 0^0 = 0
 *  1                 0^1 = 1
 *  2                 0^1^2 == 1 ^ 2 => 1 ^ 01 == 11 === 3  [ a + 1 ]
 *  3                 0^1^2^3 or 3^3 == 0
 *  4                 0^4 = 0 ^ 100 == 100 == 4
 *  5                 4^5 = 100 ^ 101 = 1
 *  6                 1^6 = 111 == 7
 *  7                 7^7 == 0
 *  8                 0 ^ 8 = 8
 *  9                  8^9 = 1
 *
 *  here we can see pattern -- if a%4 ==0 then a
 *                             if a % 4 ==1 then 1
 *                             if a % 4 ==2 then a+1
 *                             if a % 4 ==3 then 0
 *
 * @Author saurabh vaish
 * @Date 04-08-2022
 */
public class XorOfNumber {

    // program to find XOR of numbers from 0 to n
    public static void main(String[] args) {
//        int n=9;  // 1
        int n=50; // 51

        System.out.println("XOR of numbers from 0 to n = "+xORofNumber(n));

        // not good way will give time limit
//        int s=0;
//        for (int i = 0; i <=n ; i++) {
//            s=i^s;
//        }
//        System.out.println(s);

        System.out.println("XOR of numbers in range === ");
        int a = 3;
        int b=9;

        System.out.println("XOR of numbers from a= "+a+" to b=  "+b);

        // since xor(b) will give xor from 0 to so if we do once again xor with a-1 then it will remove xor of 0 to a-1 from xor b
        // as xor of same number gives 0

        System.out.println(xORofNumber(b) ^ xORofNumber(a-1));

    }

    private static int xORofNumber(int n){
        if(n % 4==0)return n;
        else if(n % 4==1)return 1;
        else if(n % 4==2)return n+1;
        else if(n % 4==3)return 0;
        return 0;
    }

}
