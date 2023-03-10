package 父子异常;

/**
 * 子类的异常只能小于等于父类的异常（父类异常的子类）或者不声明，为了让父类能够catch到
 *
 * throws
 *     直接子类一 Exception 部分可以进行捕获
 *     直接子类二 Error 虚拟机级别，程序无法处理
 */
public  class Son extends Father {
    @Override
    protected void f1() throws ArrayIndexOutOfBoundsException { // 编译成功，子类异常小于等于父类的异常
    }

//    @Override
//    protected void f1() { // 编译成功，不声明也可以
//    }

//    @Override
//    protected void f1() throws Exception { // 编译出错，子类异常只能小于等于父类的异常
////        super.sayHello();
//    }
}
