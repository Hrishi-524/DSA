package Strings;

public class Compression {
    public static StringBuilder stringCompression(StringBuilder str) {
        StringBuilder compressed = new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            int count = 1;
            while (i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++; i++;
            }
            compressed.append(str.charAt(i));
            if(count > 1) {
                compressed.append(count);
            }
        }
        return compressed;
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("");
        System.out.println(stringCompression(str));
    }
}
