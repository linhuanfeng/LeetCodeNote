package 访问修饰符.包1;
/**
 *  public>protect>default>private
 *  protect比default访问更广，不同包只要是子类也可以访问
 **/
public class Father{
    public void father1(){
        System.out.println();
    }
    protected void father2(){
        System.out.println();
    }
    void father3(){
        System.out.println();
    }
    private void father4(){
        System.out.println();
    }
}
