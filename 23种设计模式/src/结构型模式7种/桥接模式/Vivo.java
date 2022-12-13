package 结构型模式7种.桥接模式;

public class Vivo implements Brand{

    @Override
    public void open() {
        System.out.println("vivo品牌手机打开");
    }

    @Override
    public void call() {
        System.out.println("vivo品牌打电话");
    }
}
