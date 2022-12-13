package 创建型模式5种.工厂方法模式;

/**
 * 定义一个抽象的工厂接口,不同工厂实现类返回各自的图片加载对象
 *
 * 只能处理单个产品的等级结构
 */
public class Test {
    public static void main(String[] args) {
        ReadFactory factory1=new JpgReadFactory();
        Reader reader1 = factory1.getReader();
        reader1.read();

        ReadFactory factory2=new PngReadFactory();
        Reader reader2 = factory2.getReader();
        reader2.read();
    }
}
