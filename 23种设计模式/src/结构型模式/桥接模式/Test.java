package 结构型模式.桥接模式;

import java.sql.Driver;

/**
 * 桥接模式：
 * 将抽象和实现放在两个不同的类层次，将变化的抽离出来，让各部分可以独立变化，
 * 比如手机有直立和折叠，品牌有小米oppo
 *  结构化的设计模式，替换原始的继承方式。
 * 比如：手机有折叠手机和直立手机，品牌有vivo和oppo
 *
 */
public class Test {
    public static void main(String[] args) {
        Phone phone=new FolderPhone(new Vivo());
        phone.call();
    }
}
