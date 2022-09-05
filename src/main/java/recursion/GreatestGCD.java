package recursion;

/**
 * @Problem == Program to find greatest gcd between two numbers
 *
 * @Author saurabh vaish
 * @Date 14-08-2022
 */
public class GreatestGCD {

    public static void main(String[] args) {
        System.out.println("Greatest gcd == "+gcd(36,54));
    }

    private static int gcd(int n1,int n2){
        if(n1==n2)return n1;
        if(n1==0 || n2==0)return 0;
        return n1>n2?gcd(n1-n2,n2):gcd(n1,n2-n1);
    }
}
