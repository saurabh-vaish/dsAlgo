package general;

/**
 * @Author saurabh vaish
 * @Date 18-08-2022
 */
public class SqrtOfNumber {

    public static void main(String[] args) {

        int n= 40;

        System.out.println(sqrt(n));

        System.out.println(sqrtUsingBinarySearch(n,3));

        System.out.println(usingNewtonSqrt(n));
    }

    //O(log(n)
    private static double usingNewtonSqrt(int n){
        double x=n;
        double root;
        double prec = 0.5;

        while (true){
            root = prec * (x+n/x);

            if(Math.abs(root-x)<0.5){
                 break;
            }
            x=root;
        }
        return root;
    }

    // O(log(n))
    private static double sqrtUsingBinarySearch(int n,int precision) {
        int s=0,e=n;

        double root=0;
        while (s<=e){
            int m = s+(e-s)/2; // mid

            if(m*m==n)return m; // if found return

            if(m*m>n){
                e=m-1;
            }
            else {
                s=m+1;
                root=m;
            }
        }

        double inc=0.1;
        for (int i = 0; i < precision; i++) {  // loop till precision
            while (root*root<=n){
                root+=inc;  // adding inc for precision
            }
            root-=inc; // removing extra terminating condition
            inc/=10; // reducing inc as on each loop iteration it will complete one digit
        }
        return root;
    }

    // O(sqrt(n))
    private static int sqrt(int n) {
        int i=1;
        while (i*i<=n){
            i++;
        }
        return i-1;
    }
}
