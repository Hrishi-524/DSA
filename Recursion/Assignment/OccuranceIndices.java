package Recursion.Assignment;

public class OccuranceIndices {
    public static void printIndexs(int arr[], int key, int i) {
        //base case
        if(i == arr.length) {
            return;
        }
        //kaam
        if(arr[i] == key) {
            System.out.print(i+" ");
        }
        printIndexs(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;
        printIndexs(arr, key, 0);
    }
}
