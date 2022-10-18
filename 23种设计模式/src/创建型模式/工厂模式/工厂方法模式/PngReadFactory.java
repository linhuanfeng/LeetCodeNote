package 创建型模式.工厂模式.工厂方法模式;

/**
 * 定义一个抽象的工厂接口
 */
public class PngReadFactory implements ReadFactory{
    @Override
    public Reader getReader(){
        return new PngReader();
    }
}
