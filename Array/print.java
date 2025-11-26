package Array;

public class print {

    public static void printArray(int array[]) {
        System.out.print("[");
        for(int i=0; i<array.length-1; i++) {
            System.out.print(array[i]+", ");
        }
        System.out.print(array[array.length-1]);
        System.out.print("]");
    }
    
    public static void main(String[] args) {
        
    }
}
