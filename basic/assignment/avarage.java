package basic.assignment;

import java.util.Scanner;

public class avarage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers a, b, c: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        float avarage = (a + b + c) / 3;
        System.out.println("Avarage of these three numbers is :"+avarage);
        sc.close();
    }
}