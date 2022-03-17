package recursion;

/***
 *  Example of recursion using parameterized and functional approach
 */
public class RecursionInfo {
    public static void main(String[] args) {

        int n = 3;
        int sum = sumUsingParemeterised(0, n);
        System.out.println("Sum of 1 to " + n + " using parameterized approach is " + sum);
        
        int sum2 = sumUsingFunctional( n);
        System.out.println("Sum of 1 to " + n + " using functional approach is " + sum2);
    }

    // using parameterized approach
    private static int sumUsingParemeterised(int sum, int n) {
        if (n < 1) {
            return sum;
        }

        return sumUsingParemeterised(sum + n, n - 1); // in each steps its calculating then calling itself then return total result
    }

    // using parameterized approach
    private static int sumUsingFunctional(int n) {
        if (n < 1) {
            return 0;
        }

        return n + sumUsingFunctional( n - 1); // in each step its calling itself until base condition executed then adding result to all previous calls then returns
    }

}