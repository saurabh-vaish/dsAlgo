package bitwise;

/**
 * @Author saurabh vaish
 * @Date 03-08-2022
 */
public class CheckThePowerOf2 {

    public static void main(String[] args) {
        System.out.println(method1(32)); // 11 ,21, 31 ,0 ,1 ,5
        System.out.println(method2(32));
    }

    // since in power of 2 there will be only one 1 rest will be zero
    // so we can write a number as 100 == 11 + 1
    // then when we add these two numbers it will give 0 if power
    // complexity O(1)
    private static boolean method1(int n) {
        if(n<=0)return false;
        else return (n & (n-1))==0;   // getting and with n and n-1 [ represent in 111.. ]
    }

    // getting last bit by doing and with 1
    // check if its 1 then increase counter
    // drop bit by right shift
    // check if counter is 1 only as in power of 1 there will be only one 1 rest zero
    // complexity -- log(n)
    private static boolean method2(int n) {
        int c=0;
        while (n>0){
            int la = n&1; // getting last bit
            if(la==1)c++;  // check if 1
            n=n>>1;  // drop bit
        }
        return c==1;

//        if (n == 0) {
//            return false;
//        }
//        int count=0;
//        while(n>0){
//            n=n&(n-1);
//            count++;
//            if(count>1)return false;
//        }
//        return true; // change this, return true/false based on inputs

    }

}
