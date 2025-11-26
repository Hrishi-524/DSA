package Recursion.Assignment;

public class TowerOfHanoi {
    public static void TOH(int n, String src, String dest, String helper) {
        if(n == 0) {
            return;
        }
        if(n == 1) {
            System.out.println("move "+n+" from "+src+" to "+dest);
            return;
        }
        TOH(n-1, src, helper, dest);// move n-1 disk's from source to helper
        System.out.println("move "+n+" from "+src+" to "+dest);// move nth disk from source to destination
        TOH(n-1, helper, dest, src);//move n-1 disk's from helper to dest
    }
    public static void main(String[] args) {
        TOH(3, "src", "dest", "helper");
    }
}
