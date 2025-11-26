package basic.assignment;

import java.util.Scanner;

public class areaOfSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of one side of square:");
        float side = sc.nextFloat();
        System.out.println(side*side);
        sc.close();
    }
}
