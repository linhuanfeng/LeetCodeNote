package 重载和重写;

/**
 * 静态方法不能重写
 */
public class Test {
    public static void main(String[] args) {
        Father.test(); // father static test
        Son.test(); // son static test

        // 形参类型Object和Father实现重载，调用的是Father
        Father.f1(new Father()); // father f1

        CellPhone cellPhone = new SmartPhone();
        cellPhone.sendMessage(); // SmartPhone:sendMessage 调用的是SmartPhone的sendMessage，正常，运行时多态，调用的是子类
    }
}
