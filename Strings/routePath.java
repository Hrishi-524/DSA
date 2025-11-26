package Strings;

public class routePath {
    public static double findShotestPath(String path) {
        int x = 0, y = 0;
        for(int i=0; i<path.length(); i++) {
            if(path.charAt(i) == 'E') {
                x--;
            }
            if(path.charAt(i) == 'W') {
                x++;
            }
            if(path.charAt(i) == 'N') {
                y++;
            }
            if(path.charAt(i) == 'S') {
                y--;
            }
        }
        double displacement = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
        return displacement;
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(findShotestPath(path));
    }
}
