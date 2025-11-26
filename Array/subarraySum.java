package Array;

public class subarraySum {

    public static void subarray(int nums[]) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                sum=0;
                for(int k=i; k<=j; k++) {
                    sum += nums[k];
                    System.out.print(nums[k]+" ");
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
        subarray(nums);
    }
}
