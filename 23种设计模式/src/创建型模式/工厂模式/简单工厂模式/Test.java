package 创建型模式.工厂模式.简单工厂模式;
/**
 * 简单工厂模式：为工厂类传递不同的type,就可以创建不同的类型
 * 简单需要修改代码，不符合开闭原则
 */
public class Test {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("circle");
        circle.draw();
        Shape triangle = ShapeFactory.getShape("triangle");
        triangle.draw();
    }
}
