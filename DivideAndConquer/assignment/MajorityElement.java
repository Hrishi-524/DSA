package DivideAndConquer.assignment;

public class MajorityElement {
    public static int majorityElement(int arr[], int si, int ei) {
        if(si == ei) {
            return arr[si];
        }

        int mid = si + (ei-si)/2;
    
        int left = majorityElement(arr, si, mid);
        int right = majorityElement(arr, mid+1, ei);

        int leftCount = si == ei-1 ? 1 : count(arr, si, mid, left);
        int rightCount = si == ei-1 ? 1 : count(arr, mid+1, ei, right);

        return leftCount > rightCount ? left : right;
    }

    public static int count(int arr[], int si, int ei, int num) {
        if(si == ei && arr[si] == num)  {
            return 1;
        }

        if(si == ei && arr[si] != num) {
            return 0;
        }

        int mid = si + (ei-si)/2;

        return count(arr, si, mid, num) + count(arr, mid+1, ei, num);
    }
        
    public static void main(String[] args) {
        // int nums1[] = {3, 3, 4, 2, 3, 3, 3};        // Majority: 3
        int nums2[] = {2, 2, 1, 1, 1, 2, 2};        // Majority: 2
        // int nums3[] = {5, 5, 5, 5};                 // All same: 5
        // int nums4[] = {0, 0, 0, 1};                 // Majority: 0
        // int nums5[] = {6};                          // Single element: 6
        System.out.println(majorityElement(nums2, 0, nums2.length-1));
    }
}
