package binarysearch;

/**
 * @Author saurabh vaish
 * @Date 29-06-2023
 */
public class NthRootOfNumber {

    public static void main(String[] args) {
        System.out.println(" nth root = "+NthRoot(3,27));
        System.out.println(" nth root = "+NthRoot(4,69));
        System.out.println(" nth root = "+NthRoot(8,214358881));
    }

    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low =0, high = m/n; // as nth root can't be higher than its devedent by n

        while(low<=high){
            int mid = low+(high-low)/2;
            int po = powOptimize(mid,n,m);
            if(po==1)return mid;
            else if(po>1){  // if power is greater than number , then reduce it
                high=mid-1;
            }else{
                low=mid+1;  // power is less increase it
            }
        }

        return -1;
    }

    // O(n)
    private static int pow(int mid,int n,int m){
        long num=1;

        for(int i=1;i<=n;i++){
            num*=mid;
            if(num>m)return 2;
        }
        if(num==m)return 1;

        return 0;
    }


    // O(log n)
    // calculates mid ^ b , and matches with number , if matches return 1 , if mid ^ b is greater then return 2 else 0
    private static int powOptimize(int mid,int b,int number){
        int ans=1;

        while(b>0){
            if((b & 1)==1)ans = ans* mid;  // to make number even , as we are dividing then power is reduced by 1 if its odd , so multiplying if its odd
            if(ans==number)return 1;
            mid*=mid;
            if( mid > number)return 2;
            b=b >> 1;  // dividing by 2 == b = b/2;
        }


        return 0; // number is less

         // original algo
//        long ans=1;
//
//        while(b>0){
//            if((b & 1)==1)ans = ans* mid;  // to make number even , as we are dividing then power is reduced by 1 if its odd , so multiplying if its odd
//            mid*=mid;
//            b=b >> 1;  // dividing by 2 == b = b/2;
//        }
    }
}
