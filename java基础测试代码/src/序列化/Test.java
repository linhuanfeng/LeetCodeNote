package 序列化;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setId(1);
        dog.setName("huang");
        dog.setAge(18);
        System.out.println("序列化前："+dog); // 序列化前：Dog{id=1, name='huang', age=18}
        ByteArrayOutputStream os = serial(dog);
        Object o = deserial(os.toByteArray()); // 序列化后：Dog{id=1, name='huang', age=null}
        System.out.println("序列化后："+(Dog)o);
    }

    // 反序列化
    public static Object deserial(byte[] bytes) {
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(is);
            Object o = ois.readObject();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // 序列化
    public static ByteArrayOutputStream serial(Dog dog) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(os);
            oos.writeObject(dog);
            return os;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
