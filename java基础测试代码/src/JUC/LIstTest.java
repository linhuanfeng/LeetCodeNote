package JUC;

import java.util.ArrayList;

public class LIstTest {
    static volatile boolean flag=true;
    public static void main(String[] args) throws InterruptedException {
        People people = new People();
        ArrayList<People> list = new ArrayList<>();
        list.add(people);
        new Thread(()->{
            synchronized (list){
                while (flag);
            }
        }).start();
        Thread.sleep(1);

        people.setName("sdad");
        System.out.println(people.getName());
    }
    static class People{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
