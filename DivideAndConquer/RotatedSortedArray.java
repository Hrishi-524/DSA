package DivideAndConquer;

public class RotatedSortedArray {
    public static int searchInRotatedSortedArray(int nums[], int tar, int si, int ei) {
        if(si > ei) {
            return -1;
        }

        int mid = si + (ei-si)/2;

        if(nums[mid] == tar) {
            return mid;
        }

        //mid lies in left side of pivot of rotation(Line 1)
        if(nums[mid] >= nums[si]) {
            //search LEFT for (si <= tar < mid)
            if(nums[si] <= tar && tar < nums[mid]) {
                return searchInRotatedSortedArray(nums, tar, si, mid-1);
            }
            //else serach RIGHT
            else {
                return searchInRotatedSortedArray(nums, tar, mid+1, ei);
            }   
        }
        //else mid lies on right side of pivot (Line 2)
        else {
            //search RIGHT for (mid < tar <= ei) 
            if(nums[mid] < tar && tar < nums[ei]) {
                return searchInRotatedSortedArray(nums, tar, mid+1, ei);
            }
            //else serach LEFT
            else {
                return searchInRotatedSortedArray(nums, tar, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int tar = 1;
        int index = searchInRotatedSortedArray(nums, tar, 0, nums.length-1);
        System.out.println(index);
    }
}
