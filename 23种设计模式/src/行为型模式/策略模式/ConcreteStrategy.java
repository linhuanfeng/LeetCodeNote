package 行为型模式.策略模式;

// 具体的策略
public class ConcreteStrategy extends Strategy{
    @Override
    public void cal() {
        System.out.println("具体策略。。。快排");
    }
}
