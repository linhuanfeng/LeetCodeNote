package 结构型模式.桥接模式;

public class Oppo implements Brand{

    @Override
    public void open() {
        System.out.println("oppo品牌手机打开");
    }

    @Override
    public void call() {
        System.out.println("oppo品牌打电话");
    }
}
