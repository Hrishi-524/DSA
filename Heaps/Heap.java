package Heaps;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> heapArray = new ArrayList<>();

    public void add(int value) {// O(log n)
        //add at end of array
        heapArray.add(value);

        //your position
        int x = heapArray.size()-1;
        //parent position
        int par = (x-1)/2;

        //correct the heap to a min heap
        while (x > 0 && heapArray.get(x) < heapArray.get(par)) { //O(log n)
            //swap  
            int temp = heapArray.get(x);
            heapArray.set(x, heapArray.get(par));
            heapArray.set(par, temp);

            //update x
            x = par;
            par = (x-1)/2;
            if (par < 0) {
                break;
            }
        }   
    }

    public int peek() {
        return heapArray.get(0);
    }

    public int remove() { // O(log n)
        // Date to be removed
        int data = heapArray.get(0);

        // last index
        int lastIdx = heapArray.size()-1;
        
        // Step 1 - Swap first and last nodes
        int temp = heapArray.get(0);
        heapArray.set(0, heapArray.get(lastIdx));
        heapArray.set(lastIdx, temp);

        //step 2 - Delete the last index
        heapArray.remove(lastIdx);

        //step 3 - heapify O(log n)
        heapify(0);

        return data;
    }

    private void heapify(int i) {//O(log n)
        int left = 2*i+1;
        int right = 2*i+2;
        int minIdx = i;

        if(left < heapArray.size() && heapArray.get(left) < heapArray.get(minIdx)) {
            minIdx = left;
        }

        if(right < heapArray.size() && heapArray.get(right) < heapArray.get(minIdx)) {
            minIdx = right;
        }

        if(minIdx != i) {
            int temp = heapArray.get(i);
            heapArray.set(i, heapArray.get(minIdx));
            heapArray.set(minIdx, temp);

            heapify(minIdx); //O(log n)
        }
    }
}
