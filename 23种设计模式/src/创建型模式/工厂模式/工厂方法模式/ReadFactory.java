package 创建型模式.工厂模式.工厂方法模式;

/**
 * 定义一个抽象的工厂接口,不同工厂实现类返回各自的图片加载对象
 */
public interface ReadFactory {
    Reader getReader();
}
