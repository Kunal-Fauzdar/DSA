public class shortestPath {
    public static void main(String[] args) {
        String dir = "WNEENESENNN";
        System.out.println(getShortestPath(dir));
    }
    public static double getShortestPath(String dir){
        int x=0;
        int y=0;
        for(int i=0;i<dir.length();i++){
            if(dir.charAt(i)=='N'){
                x++;
            }
            else if(dir.charAt(i)=='S'){
                x--;
            }
            else if(dir.charAt(i)=='W'){
                y--;
            }
            else if(dir.charAt(i)=='E'){
                y++;
            }
        }
        double x2= x*x;
        double y2=y*y;
        return Math.sqrt(x2+y2);
    }
}
