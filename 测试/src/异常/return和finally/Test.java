package 异常.return和finally;

public class Test {
    public static int getAge(){
        int a=0;
        try {
            return ++a;
        }catch (Exception e){
        }finally {
            return ++a;
        }
    }

    public static void print(){
        int i=8;
        System.out.println(++i+1); // 10
        System.out.println(i+++1); // 10
    }

    public static void main(String[] args) {
        System.out.println(getAge()); // 2
        print();
    }
}
