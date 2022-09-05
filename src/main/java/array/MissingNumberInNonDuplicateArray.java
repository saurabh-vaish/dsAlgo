package array;

/**
 * @Author saurabh vaish
 * @Date 27-08-2022
 */
public class MissingNumberInNonDuplicateArray {

    public static void main(String[] args) {
        int [] ar = {2,3,0,5,1};

        System.out.println("missing number == "+findMissing(ar));

        System.out.println("missing number == "+findMissingUsingXOR(ar));

        System.out.println("missing number == "+findMissingWhenArrayStartsFromCertainRange(new int[]{22,23,26,25,27},22));
    }

    // O(N) , O(1)
    // this program will work when we need to find missing number in first n numbers.
    static int findMissing(int [] ar){
        int n =ar.length;

        int totalSum = n*(n+1)/2;  // if elements are starting from 1 then (n+1)*(n+1+1)/2
        int sum=0;
        for (int a:ar){
            sum+=a;
        }
        return totalSum-sum;
    }

    static int findMissingUsingXOR(int [] ar){
        int n =ar.length;

        int x = n;
        for (int i = 0; i < n; i++) {
            x=x ^ i ^ ar[i];
        }

        return x;
    }


    // O(N) , O(1)
    // this program will work when we need to find missing number in first n numbers.
    static int findMissingWhenArrayStartsFromCertainRange(int [] ar,int rangeStart){
        int n =ar.length+1;  // +1 as range and array length sum diff [ range = 22 to 27 == 6 , ar length = 5 ]
        int rem = rangeStart%10;
        int d=1;

        int totalSum = (n)*(2*rangeStart+(n-1)*d)/2;  // if elements are starting from 1 then (n+1)*(n+1+1)/2

//        totalSum= totalSum * (rangeStart-rem);
        int sum=0;
        for (int a:ar){
            sum+=a;
        }
        return totalSum-sum;
    }

}
