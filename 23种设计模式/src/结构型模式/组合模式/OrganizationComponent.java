package 结构型模式.组合模式;
// 可分为叶子leaf和component,叶子有具体的行为，component可以添加其他component或叶子
public abstract class OrganizationComponent {
    private String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void add(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }
    protected void remove(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }
    // 抽象行为的，所有子类都要实现
    abstract void print();
}
