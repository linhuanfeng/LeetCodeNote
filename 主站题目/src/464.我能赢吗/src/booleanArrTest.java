public class booleanArrTest {
    public static void main(String[] args) {
        boolean[] arr=new boolean[3];
        for (boolean b : arr) {
            System.out.println(b);// 默认为false的啊
        }
        // System.out.println(arr[0]==null);//Operator '==' cannot be applied to 'boolean', 'null'
    }
}
