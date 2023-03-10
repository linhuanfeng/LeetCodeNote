package 值传递;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Dog dog = new Dog("666");
        System.out.println("实参："+dog); // 实参：Dog{name='666'}值传递.Test$Dog@1b6d3586
        test.update(dog); // 会被修改，虽然是值传递，但是指向的同一块地方
        System.out.println("实参："+dog); // 实参：Dog{name='777'}值传递.Test$Dog@1b6d3586
    }
    private void update(Dog dog){
        System.out.println("形参："+dog); // 形参：Dog{name='666'}值传递.Test$Dog@1b6d3586
        dog.setName("777");
    }
    static class Dog{
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}'+getClass().getName() + "@" +Integer.toHexString(hashCode());
        }
    }
}
