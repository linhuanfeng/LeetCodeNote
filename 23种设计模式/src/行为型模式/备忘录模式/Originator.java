package 行为型模式.备忘录模式;

/**
 * 需要保存状态的对象
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateMemento(){
        return new Memento(state);
    }

    // 通过备忘录恢复状态
    public void resetStateFromMemento(Memento memento){
        state= memento.getState();
    }
}
