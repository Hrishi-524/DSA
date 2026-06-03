package Array.dsa_sheet;

public class mergeSortedArrays {
    /**
     * solution like merge sort - remember here to write i < m instead of i <= m
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        
        int[] merged = new int[m+n];
        int k = 0;

        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while(i < m) {
            merged[k++] = nums1[i++];
        }

        while(j < n) {
            merged[k++] = nums2[j++];
        }

        for(int idx=0; idx<merged.length; idx++) {
            nums1[idx] = merged[idx];
        }
    }

    /*
     * Solution with O(1) space , no merged[] array
     */
    public static void main(String[] args) {
        
    }
}
