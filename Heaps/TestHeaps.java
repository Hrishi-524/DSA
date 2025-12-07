package Heaps;

import Heaps.Heap;

public class TestHeaps {
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(2);
        h.add(10);
        h.add(7);
        h.add(1);

        while (!h.heapArray.isEmpty()) {
            System.out.print(h.peek()+" ");
            h.remove();
        }
    }
}
