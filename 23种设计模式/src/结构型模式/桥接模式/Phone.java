package 结构型模式.桥接模式;

public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }
    protected void open(){
        this.brand.open();
    }
    protected void call(){
        this.brand.call();
    }
}
