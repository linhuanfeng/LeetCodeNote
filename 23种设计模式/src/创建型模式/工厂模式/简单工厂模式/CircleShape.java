package 创建型模式.工厂模式.简单工厂模式;

// 圆
public class CircleShape implements Shape {
    public CircleShape(){
        System.out.println("circle...被创建");
    }
    @Override
    public void draw() {
        System.out.println("circle....画圆");
    }
}
