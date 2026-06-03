package DivideAndConquer;

public class MergeSort {
    public static void printArr(int arr[]) {
        System.out.print("[");
        for(int idx=0; idx<arr.length; idx++) {
            if(idx == arr.length-1) {
                System.out.print(arr[idx]);
            } else {
                System.out.print(arr[idx]+", ");
            }
        }
        System.out.print("]");
    }

    public static void merge(int arr[], int st, int mid, int end) {
        int i=st;
        int j=mid+1;
        int k=0;
        int merged[] = new int[end-st+1];

        while (i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                merged[k++] = arr[i++];
            } else {
                merged[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            merged[k++] = arr[i++];
        }

        while (j <= end) {
            merged[k++] = arr[j++];
        }

        for(k=0, i=st; k<merged.length; k++, i++) {
            arr[i] = merged[k];
        }
    }

    public static void mergesort(int arr[], int st, int end) {
        if(st >= end) {
            return;
        }

        int mid = st + (end - st)/2;

        mergesort(arr, st, mid);
        mergesort(arr, mid+1, end);
        merge(arr, st, mid, end);
    }

    public static int[] sort(int arr[]) {
        mergesort(arr, 0, arr.length-1);
        printArr(arr);
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8, 7, 3,4,6, 82, 3, 23,33};
        sort(arr);
    }
}
