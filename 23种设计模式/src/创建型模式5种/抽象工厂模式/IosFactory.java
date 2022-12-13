package 创建型模式5种.抽象工厂模式;

public class IosFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new IosOperationController();
    }
    @Override
    public UIController createInterfaceController() {
        return new IosUIController();
    }
}