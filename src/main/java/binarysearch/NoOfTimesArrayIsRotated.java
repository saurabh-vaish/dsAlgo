package binarysearch;

/**
 * @Author saurabh vaish
 * @Date 11-06-2023
 */
public class NoOfTimesArrayIsRotated {

    public static void main(String[] args) {
        int[] ar={4,5,6,7,8,9,1,2,3};
//        int[] ar={1};

        int min = array_rotation_number(ar);

        System.out.println("rotation = "+min);
    }

    // log(n)
    private static int array_rotation_number(int[] ar) {
        int left=0;
        int right= ar.length-1;
        int ans = Integer.MAX_VALUE;
        int index=-1;

        if(ar.length==1){
            return 0;
        }
        while (left<=right){
            int mid=left + (right-left)/2;

//            if(ar[left]==ar[mid] && ar[mid]==ar[right]){  // checking if elements are same for boundary then trim search space
//                left++;
//                right--;
//                continue;
//            }

            if(ar[left]<=ar[right]){ // already sorted
                if(ar[left]<ans){
                    ans=ar[left];
                    index = left;
                }
                break;
            }

            if(ar[left]<=ar[mid]){
                if(ar[left]<ans){
                    ans=ar[left];
                    index = left;
                }
                left=mid+1; // search in other part , eliminate left
            }else {
                if(ar[mid]<ans){
                    ans=ar[mid];
                    index = mid;
                } // mid because high will be always greater
                right = mid-1;
            }
        }
        return index;
    }


}
