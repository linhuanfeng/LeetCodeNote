package 集合.流操作;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        List<Person> list=new ArrayList<>();
        Person person = new Person();
        list.add(person);
        // Collectors.toMap不能为空
        list.stream().findAny().map(Person::getName).orElse(null); // 判断value是否存在，否则返回other
    }
    static class Person{
        String name;
        String age;

        public Person() {}

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
