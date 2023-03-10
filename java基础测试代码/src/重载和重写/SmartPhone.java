package 重载和重写;

public class SmartPhone extends AbstractCellPhone{

    @Override
    public void sendMessage() {
        System.out.println("SmartPhone:sendMessage");
    }
}
