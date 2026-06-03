package Array.assignment1;

public class rotatedSortedArray {
    public static int searchInRotatedSortedArray(int nums[], int tar) {
        int n = nums.length;
        int start = 0, end = n-1;
        
        while (start <= end) {
            int mid = (start + end)/2;

            if(tar == nums[mid]) {
                return mid;
            }
            // rotation is on left side of mid
            if (nums[mid] >= nums[start]) {
                if (tar >= nums[start] && tar <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { //rotation is on the right side of mid
                if (tar >= nums[mid] && tar <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    
    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int tar = 0;
        int index = searchInRotatedSortedArray(nums, tar);
        System.out.println(index);
       
        System.out.println((Math.sqrt(18)));
    }
}
