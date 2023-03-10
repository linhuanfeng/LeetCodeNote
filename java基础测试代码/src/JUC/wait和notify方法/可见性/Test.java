package JUC.wait和notify方法.可见性;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dog.flag=true;
            System.out.println("修改flag为true："+System.currentTimeMillis());
        }).start();
        new Thread(()->{
            while (!dog.flag){ // 不加volatile的时候flag并不能马上获取最新的值
            }
            System.out.println("退出循环："+System.currentTimeMillis());
        }).start();
    }
}
class Dog{
//    public boolean flag=false;
    public volatile boolean flag=false;
}