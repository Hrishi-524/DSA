package Fun;

import java.util.Scanner;

public class DictionaryString {
    private static String typeOfChar(char charecter) {
        for(char ch = 'a'; ch <= 'z'; ch++) {
            if(ch == charecter) {
                return "lowercase";
            }
        }
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            if(ch == charecter) {
                return "uppercase";
            }
        }
        for(char ch = '0'; ch <= '9'; ch++) {
            if(ch == charecter) {
                return "number";
            }
        }
        return "special";
    }

    private static void threadIt(int delay) {
        try {
            Thread.sleep(delay); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        }
    }

    public static void dictionaryString(String str) {
        StringBuilder ds = new StringBuilder("");
        int count = 1;
        int page = 1;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ' ') {
                ds.append(" ");
                threadIt(100);
                System.out.println(ds);
                count++; page++;
                continue;
            }

            String type = typeOfChar(str.charAt(i));

            if(type.equals("special")) {
                ds.append(str.charAt(i));
                threadIt(100);
                System.out.println(ds);
                count++; page++;
                continue;
            } else if (type.equals("lowercase")) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    threadIt(100);
                    ds.append(ch);
                    System.out.println(ds);
                    if(ch == str.charAt(i)) {
                        page = 26*(str.indexOf(str.charAt(i))+1);
                        break;
                    }
                    ds.deleteCharAt(ds.length()-1);
                    count++; page++;
                }
            } else if (type.equals("uppercase")) {
                for(char ch = 'A'; ch <= 'Z'; ch++) {
                    threadIt(100);
                    ds.append(ch);
                    System.out.println(ds);
                    if(ch == str.charAt(i)) {
                        page = 26*(str.indexOf(str.charAt(i))+1);
                        break;
                    }
                    ds.deleteCharAt(ds.length()-1);
                    count++; page++;
                }
            } else {
                for(char ch = '0'; ch <= '9'; ch++) {
                    threadIt(100);
                    ds.append(ch);
                    System.out.println(ds);
                    if(ch == str.charAt(i)) {
                        page = 26*(str.indexOf(str.charAt(i))+1);
                        break;
                    }
                    ds.deleteCharAt(ds.length()-1);
                    count++; page++;
                }
            }
        }

        System.out.println("Found //"+ds+ "// in "+count+" Iterations and is on page no."+page);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("write something for fun dictonary :");
        String input = sc.nextLine();
        sc.close();
        dictionaryString(input);
    }
}

