package 访问修饰符.包1;

public class Son2 extends Father {
    public void son2(){
        father3(); // 受修饰符影响，不能直接访问父类的方法
    }
}
