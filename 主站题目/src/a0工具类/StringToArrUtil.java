package a0工具类;

public class StringToArrUtil {
    public static void main(String[] args) {
        System.out.println(StringToArray("[[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]"));
    }
    /**
     * [[-52,31],[-73,-26],[82,97],[-65,-11]]
     */
    public static String StringToArray(String str){
        str=str.replaceAll("\\[","{");
        str=str.replaceAll("\\]","}");
        return str;
    }
}
