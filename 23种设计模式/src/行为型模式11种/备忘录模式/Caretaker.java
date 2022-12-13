package 行为型模式11种.备忘录模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 守护者对象，使用集合管理多个备忘录对象
 */
public class Caretaker {
    private List<Memento> mementoList=new ArrayList<>();
    public void add(Memento memento){
        mementoList.add(memento);
    }
    public Memento get(int index){
        return mementoList.get(0);
    }
}
