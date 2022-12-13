package 创建型模式5种.工厂方法模式;

/**
 * 定义一个抽象的工厂接口
 */
public class JpgReadFactory implements ReadFactory {
    @Override
    public Reader getReader(){
        return new JpgReader();
    }
}
