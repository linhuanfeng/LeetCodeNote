package 行为型模式11种.策略模式;

// 环境角色，持有策略的引用
public class Context {
    Strategy strategy=null;
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    public void doInterface(){
        strategy.cal();
    }
}
