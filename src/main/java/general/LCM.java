package general;

/**
 * @Author saurabh vaish
 * @Date 29-01-2023
 */
public class LCM {
    public static void main(String[] args) {

        System.out.println("LCM == "+lcmBruteForce(4,8));

        System.out.println("LCM == "+lcmUsingEuclidean(4,8));
    }

    // in this method we will find the gcd of them and then use formula = (a*b)/gcd(a,b)
    // complexity - O(min (a,b))
    private static int lcmBruteForce(int a,int b){
        int gcd = 1;
        for (int i = Math.min(a,b); i >=1 ; i--) {
            if(a%i==0 && b%i==0){
                gcd=i;
                break;
            }
        }

        return (a*b)/gcd;
    }


    // euclidean theorem is used to find the gcd of two numbers , using dividing them until one of them becomes zero
    // after finding the gcd we can use logic lcm= (a*b)/gcd(a,b)
    // complexity = same as gcd O(logɸ min(a,b)) , where phy is the times number is being devided
    private static int lcmUsingEuclidean(int a,int b){
        return (a*b)/gcd(a, b);
    }

    private static int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }

}
