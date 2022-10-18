package 创建型模式.单例模式;

/**
 * 双重判断--》可实现懒加载
 */
public class SingleTon {
    private static volatile SingleTon instance=null;  // 防止指令重排；保证线程可见性
    private SingleTon(){}
    public static SingleTon getInstance(){
        if(instance==null){
            synchronized (SingleTon.class){
                if(instance==null){
                    instance=new SingleTon();
                }
            }
        }
        return instance;
    }
}
