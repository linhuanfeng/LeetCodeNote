package 不同接口相同方法;

public class InterfaceImpl implements Interface1, Interface2 {
    @Override
    public void save() {
        System.out.println("save..");
    }
}
