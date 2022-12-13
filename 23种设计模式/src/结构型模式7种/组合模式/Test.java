package 结构型模式7种.组合模式;
/**
 * 组合模式：
 * 结构性设计模式
 * 角色：component,组合对象声明接口
 *      leaf,表示叶子结点，没有子节点
 *      composite,非叶子结点，可存储子节点
 * 优点：易于构建树状结构，表示部分和整体层次，同时增删都很方便
 *
  */
public class Test {
    public static void main(String[] args) {
        OrganizationComponent pekingCollege=new College("北京大学");
        OrganizationComponent computerDepartment = new College("计算机学学院");
        OrganizationComponent software=new Department("软件工程专业");

        pekingCollege.add(computerDepartment);
        computerDepartment.add(software);

        pekingCollege.print();
        // 北京大学下设所有学院有：
        //计算机学学院下设所有学院有：
        //我是:软件工程专业
    }
}
