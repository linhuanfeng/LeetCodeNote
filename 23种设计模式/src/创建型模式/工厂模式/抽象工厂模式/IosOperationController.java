package 创建型模式.工厂模式.抽象工厂模式;

class IosOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("IosOperationController");
    }
}