package 结构型模式.桥接模式;

public class FolderPhone extends Phone{
    public FolderPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open() {
        super.open();
        System.out.println("折叠手机打开");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("折叠手机打电话");
    }
}
