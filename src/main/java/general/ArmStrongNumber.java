package general;

/**
 * @Author saurabh vaish
 * @Date 30-08-2022
 */
public class ArmStrongNumber {

    public static void main(String[] args) {

        int n = 153;
        System.out.println(armStrongNumber(n));
    }

    static boolean armStrongNumber(int n){
        int c = Integer.toString(n).length();
        int temp=n;
        int sum=0;
        while (n>0){
            int rev = n%10;
            sum+=(int)Math.pow(rev,c);
            n/=10;
        }
        return sum==temp;
    }
}
