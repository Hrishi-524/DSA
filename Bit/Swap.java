package Bit;

public class Swap {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        //swap
        a = a+b;// a = (a+b)
        b = a-b;// b = a-b = (a+b)-b = a
        a = a-b;// a = a-b = (a+b)-a = b
        System.out.println("First swap (using +-) : "+a+" "+b);

        //swap
        a = a^b;// a = (a^b)
        b = a^b;// b = a^b = (a^b)^b = a^b^b = a^(b^b) = a^0 = a {xor follow commutative property}
        a = a^b;// a = a^b = (a^b)^a = b^0 = b
        System.out.println("Second swap (using xor) : "+a+" "+b);
    }
}
