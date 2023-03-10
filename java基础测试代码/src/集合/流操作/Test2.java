package 集合.流操作;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<Person> list=new ArrayList<>();
        Person person2 = new Person("john2", null);
        Person person1 = new Person("john1", "22");
        list.add(person1);
        list.add(person2);

        Optional<String> optional = list.stream().map(e -> e.getAge()).findAny();// 不会空指针异常,随机返回一个不为空
        System.out.println(optional.get());
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
