package DivideAndConquer;

public class QuickSort {
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

    public static void quicksort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }

        int partitionIdx = partition(arr, si, ei);
        quicksort(arr, si, partitionIdx-1);
        quicksort(arr, partitionIdx+1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;

        for(int j=si; j<ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                //swap arr[i] and arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        //swap arr[i] and arr[ei](pivot)
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        quicksort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
