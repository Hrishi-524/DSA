package Array;

public class prefixSum {
    public static void subarraySumPerfix(int nums[]) {  // O(n^2)
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int prefix[] = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            if(i==0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = prefix[i-1] + nums[i];
            }
        }

        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                if(sum == 0 || i == 0) {
                    sum = prefix[j];
                } else {
                    sum = prefix[j] - prefix[i-1];
                }

                if ( max < sum ) {
                    max = sum;
                } 
                if ( sum < min) {
                    min = sum;
                }
                System.out.print(" Subarray Sum ="+sum);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Max Sum among all subarray sum ="+max);
        System.out.println("Min Sum among all subarrat sum ="+min);
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        subarraySumPerfix(nums);
    }
}
