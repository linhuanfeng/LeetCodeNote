package 重载和重写;

public abstract class AbstractCellPhone implements CellPhone{
    private int x=-1; // 抽象类算是普通的类，也是可以有私有成员的
    @Override
    public void sendMessage() {
        System.out.println("AbstractCellPhone:sendMessage");
    }
}


