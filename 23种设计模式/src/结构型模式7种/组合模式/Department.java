package 结构型模式7种.组合模式;

public class Department extends OrganizationComponent{

    public Department(String name) {
        super(name);
    }

    @Override
    void print() {
        System.out.println("我是:"+getName());
    }
}
