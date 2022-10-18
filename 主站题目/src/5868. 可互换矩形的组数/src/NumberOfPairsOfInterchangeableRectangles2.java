import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfInterchangeableRectangles2 {
    public static void main(String[] args) {
        int[][] rectangles={{4,8},{3,6},{10,20},{15,30}};
        System.out.println(interchangeableRectangles(rectangles));
        System.out.println(gcd(1, 9));
    }
    public static long interchangeableRectangles(int[][] rectangles) {
        Map<Long,Integer> hashMap = new HashMap<>();

        for (int[] rectangle : rectangles) {
            int w=rectangle[0],h=rectangle[1];
            int gcd=gcd(w,h);
            long lon=(w/gcd)*100000+(h/gcd);// 类似字符串的拼接
            Integer cnt = hashMap.getOrDefault(lon, 0);
            hashMap.put(lon,++cnt);
        }
        long res=0;
        for (int val : hashMap.values()) {
            if(val>1){
                res+=(val*1.0*(val-1)/2);
            }
        }
        return res;
    }
    static int gcd(int a,int b){
        if(a<b){
            gcd(b,a);
        }
        return a%b==0?b:gcd(b,a%b);
    }
}
