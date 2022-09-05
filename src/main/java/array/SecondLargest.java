package array;

/**
 * @Author saurabh vaish
 * @Date 23-08-2022
 */
public class SecondLargest {

    public static void main(String[] args) {

        int ar[] = {2,35,1,5,45};

        method1(ar);

        System.out.println(efficientSolSecondLargest(ar));
        System.out.println(efficientSolSecondMinimum(ar));


    }

    // complexity == O(N)
    // space = O(1)
    static int efficientSolSecondLargest(int ar[]){
        int largest=Integer.MIN_VALUE;
        int secondLargest=largest;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i]>largest){
                secondLargest=largest;
                largest=ar[i];
            }
            else if(ar[i]>secondLargest && ar[i]!=largest){
                secondLargest=ar[i];
            }
        }
        return secondLargest;
    }

    // complexity == O(N)
    // space = O(1)
    static int efficientSolSecondMinimum(int ar[]){
        int minimum=Integer.MAX_VALUE;
        int secondMinimum=minimum;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i]<minimum){
                secondMinimum=minimum;
                minimum=ar[i];
            }
            else if(ar[i]<secondMinimum && ar[i]!=minimum){
                secondMinimum=ar[i];
            }
        }
        return secondMinimum;
    }


    // complexity == O(n) + O(n) == O(n) ,
    // space = O(1)
    static void method1(int ar[]){
        int largest=Integer.MIN_VALUE;
        int secondLargest=largest;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i]>largest){
                largest=ar[i];
            }
        }

        for (int i = 0; i < ar.length; i++) {
            if(ar[i]!=largest){
                if(ar[i]>secondLargest && secondLargest<largest){
                    secondLargest=ar[i];
                }
            }
        }

        System.out.println(largest);
        System.out.println(secondLargest);
    }

}
