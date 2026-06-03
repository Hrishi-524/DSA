package Bit;

public class Operations_GET_SET_CLEAR_UPDATE {
    public static int getBit(int n, int i) {
        int bitMask = 1 << i;
        return (n & bitMask) == 0 ? 0 : 1;
    }

    public static int setBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int toggleBit(int n, int i) {
        int bitMask = 1 << i;
        return n ^ bitMask;
    }

    public static int updateBit(int n, int i, int newBit) {
        n = clearBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int clearLastBits(int n, int i) {
        int bitMask = -1 << i;
        return n & bitMask;
    }

    public static int clearRangeOfBits(int n, int i, int j) {
        int left = (-1 << (j+1));
        int right = (1 << i) - 1; // alternatively you can use ~(-1 << i)
        int bitMask = left | right;
        return n & bitMask;
    }

    public static int countSetBits(int n) {
        //O(log n + 1)
        //for any number n we need log(base 2)n number of bits to represent it
        int count = 0;
        while (n != 0) {
            int lsb = n & 1;
            if(lsb == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int n = 255; // 255

        System.out.println("getBit(n, 3): " + getBit(n, 3));       // 1
        System.out.println("setBit(n, 0): " + setBit(n, 0));       // 255
        System.out.println("clearBit(n, 1): " + clearBit(n, 1));   // 253
        System.out.println("switchBit(n, 2): " + toggleBit(n, 2)); // 251
        System.out.println("updateBit(n, 4, 0): " + updateBit(n, 4, 0)); // 239
        System.out.println("clearLastBits(n, 4): " + clearLastBits(n, 4)); // 240
        System.out.println("clearRangeOfBits(n, 2, 5): " + clearRangeOfBits(n, 2, 5)); // 195
    }
}
