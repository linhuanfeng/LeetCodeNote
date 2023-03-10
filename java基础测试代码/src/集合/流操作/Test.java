package 集合.流操作;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Person> list=new ArrayList<>();
        Person person1 = new Person("john1", "22");
//        Person person1 = new Person("john1", null); // 空指针异常
        Person person2 = new Person("john2", "asdad");
        list.add(person1);
        list.add(person2);
        // Collectors.toMap不能为空
        Map<String, String> map = list.stream().collect(Collectors.toMap(e -> e.getName(), e -> e.getAge()));
    }
    static class Person{
        String name;
        String age;

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
