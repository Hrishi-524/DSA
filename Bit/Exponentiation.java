package Bit;

public class Exponentiation {
    public static int fastExponentiation(int a, int n) {
        int ans = 1;

        while (n > 0) {
            // lsb = n & 1
            if((n & 1) == 1) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    //IMPORATNT - we need to calculate (a^n) % m
    //but a^n using fastExpo and then reslut%m leads to overlfow
    //i dont understand solution ans reasoning
    public static int modularExponentiation(int a, int n, int m) {
        int ans = 1;
        a = a%m;
        while (n > 0) {
            if((n & 1) == 1) {
                ans = (ans * a)%m;
            }
            a = (a * a)%m;
            n = n >> 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
