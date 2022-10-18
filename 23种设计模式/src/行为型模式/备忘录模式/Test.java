package 行为型模式.备忘录模式;

/**
 * 在不破坏封装性的前提下，保存一个对象的内部状态，方便以后恢复到原先保存的状态
 */
public class Test {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        originator.setState("111");
        // 保存状态111
        Memento state1 = originator.saveStateMemento();
        caretaker.add(state1);

        originator.setState("222");
        // 保存状态222
        Memento state2 = originator.saveStateMemento();
        caretaker.add(state2);

        originator.setState("333");
        System.out.println("当前状态为："+originator.getState());

        originator.resetStateFromMemento(caretaker.get(0));
        System.out.println("恢复状态为："+originator.getState());
    }
}
