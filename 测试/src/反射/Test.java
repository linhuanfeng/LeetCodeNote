package 反射;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        Class<UserController> claz = UserController.class;
        Class<UserController> claz = (Class<UserController>) Class.forName("反射.UserController");
//        Class<UserController> claz = (Class<UserController>) new UserController().getClass();
        UserController obj = claz.getConstructor().newInstance();
        Field field = claz.getDeclaredField("userService");
        UserService service = new UserService();

//        field.setAccessible(true);
//        field.set(obj,service); // 通过field直接设置字段属性

        Method meth = claz.getMethod("setUserService", UserService.class);
        Object invoke = meth.invoke(obj, service); // 通过set方法设置字段值
        System.out.println(meth);
        System.out.println(obj.getUserService());
    }
}
