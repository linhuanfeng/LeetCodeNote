package 创建型模式5种.工厂方法模式;

public class PngReader implements Reader {
    @Override
    public void read() {
        System.out.println("读取 png 图片");
    }
}
