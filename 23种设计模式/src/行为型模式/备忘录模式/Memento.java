package 行为型模式.备忘录模式;

/**
 * 备忘录对象，负责保护好Originator的内部状态
 */
public class Memento {
    private String state;
    public Memento(String state){
        this.state=state;
    }

    public String getState() {
        return state;
    }
}
