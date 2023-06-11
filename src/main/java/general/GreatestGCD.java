package general;

/**
 * @Problem == Program to find greatest gcd between two numbers / or highest common factor ( HCF )
 *
 * @Author saurabh vaish
 * @Date 14-08-2022
 */
public class GreatestGCD {

    public static void main(String[] args) {

        System.out.println("Greatest gcd bruteforce == "+gcdBruteForce(36,54));
        System.out.println("Greatest gcd == "+gcd(36,54));
        System.out.println("Greatest gcd better == "+gcdBetter(36,54));
    }

    private static int gcd(int n1,int n2){
        if(n1==n2)return n1;
        if(n1==0 || n2==0)return 0;
        return n1>n2?gcd(n1-n2,n2):gcd(n1,n2-n1);
    }

    // using euclidean theorem
    // complexity = O(logɸ min(a,b))
    private static int gcdBetter(int n1,int n2){
        if(n1==0)return n2;
        if(n2==0)return n1;
        return n1>n2?gcdBetter(n1%n2,n2):gcdBetter(n1,n2%n1);

//        or
//        if(b==0)return a;
//        return gcd(b,a%b);

    }


    // complexity == O( min (n1,n2))
    private static int gcdBruteForce(int n1,int n2){

        int n = Math.min(n1,n2);
        for (int i =n ;i>=1; i--) {
            if(n1%i==0 && n2%i==0){
                return i;
            }
        }
        return -1;
    }






}
