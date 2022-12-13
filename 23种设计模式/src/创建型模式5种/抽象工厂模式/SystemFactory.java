package 创建型模式5种.抽象工厂模式;

// 下面定义一个抽闲工厂，该工厂需要可以创建OperationController和UIController。
public interface SystemFactory {
    public OperationController createOperationController();
    public UIController createInterfaceController();
}