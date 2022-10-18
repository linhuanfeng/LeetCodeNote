package 访问修饰符.包2;


import 访问修饰符.包1.Father;

class Son extends Father {

    public void son1(){
        father1();
        father2();
//        father3(); // 默认得在同一包下才可以访问
//        father4(); // 私有
    }

}
