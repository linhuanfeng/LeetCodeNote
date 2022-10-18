package 创建型模式.工厂模式.简单工厂模式;

// 三角形
public class TriangleShape implements Shape {
    public TriangleShape(){
        System.out.println("triangle...被创建");
    }
    @Override
    public void draw() {
        System.out.println("triangle....画三角形");
    }
}
