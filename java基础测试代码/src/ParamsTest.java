public class ParamsTest {
    public static void main(String[] args) {
        ParamsTest test = new ParamsTest();
        int[] a={1,3};
        test.func(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" "); // -1 -1 值会改变
        }
    }
    public void func(int[] a){
        for (int i = 0; i < a.length; i++) {
            a[i]=-1;
        }
    }
}
