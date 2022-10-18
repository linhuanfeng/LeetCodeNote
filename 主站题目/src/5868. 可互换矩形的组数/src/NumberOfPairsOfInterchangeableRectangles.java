import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfInterchangeableRectangles {
    public static void main(String[] args) {
        int[][] rectangles={{4,8},{3,6},{10,20},{15,30}};
        System.out.println(interchangeableRectangles(rectangles));
    }
    public static long interchangeableRectangles(int[][] rectangles) {
        Map<Double,Integer> hashMap = new HashMap<>();

        for (int[] rectangle : rectangles) {
            double t=rectangle[0]*1.0/rectangle[1];
            Integer cnt = hashMap.getOrDefault(t, 0);
            hashMap.put(t,++cnt);
        }
        long res=0;
        for (int val : hashMap.values()) {
            if(val>1){
                res+=(val*1.0*(val-1)/2);
            }
        }
        return res;
    }
}
