package 创建型模式.工厂模式.简单工厂模式;

/**
 * 简单工厂模式：为工厂类传递不同的type,就可以创建不同的类型
 * 简单需要修改代码，不符合开闭原则
 */
public class ShapeFactory {
    public static Shape getShape(String type){
        Shape shape=null;
        if("circle".equals(type)){
            shape= new CircleShape();
        }else if("triangle".equals(type)){
            shape= new TriangleShape();
        }
        return shape;
    }
}
