package DivideAndConquer.assignment;

public class MergeSortString {

    public static void printArr(String arr[]) {
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

    public static void mergesort(String arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }

        int mid = si + (ei-si)/2;

        mergesort(arr, si, mid);
        mergesort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(String arr[], int si, int mid, int ei) {
        int i = si;
        int j = mid+1;
        int k = 0;
        String merged[] = new String[ei-si+1];

        while (i <= mid && j <= ei) {
            if(arr[i].compareTo(arr[j]) <= 0) {
                merged[k++] = arr[i++];
            } else {
                merged[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            merged[k++] = arr[i++];
        }

        while (j <= ei) {
            merged[k++] = arr[j++];
        }

        for(k=0, i=si; k<merged.length; k++, i++) {
            arr[i] = merged[k];
        }
    }

    public static void main(String[] args) {
        String words[] = { "sun", "earth", "mars", "mercury"};
        mergesort(words, 0, words.length-1);
        printArr(words);
    }
}
