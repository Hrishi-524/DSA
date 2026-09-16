package CodeForces;
import java.util.*;

public class IskanderAndDrawings {
    private static int eraseLine(String line, int n) {
        int maxTime = 0;
        
        for(int i=0; i<n; i++) {
            if(line.charAt(i) == '*') {
                continue;
            }

            int len = 0;
            while(i<n && line.charAt(i) == '#') {
                len++; i++;
            }
            int time = (int) Math.ceil((double)len/2);
            maxTime = Math.max(maxTime, time);
        }

        return maxTime;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int ans = eraseLine(s, n);

            System.out.println(ans);
        }

        sc.close();
    }
}
