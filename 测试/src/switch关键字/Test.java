package switch关键字;

/**
 * java八大基本数据类型：byte,char,short,int,long,float,double,boolean
 * 注意String是原生类
 * 支持switch的有byte,short,char,int，String,enum
 */
public class Test {
    public static void main(String[] args) {
        // 八大基本类型
        byte b=1;
        char c='1';
        short s=1;
        int i=1;
        long l=1;
        double d=1.0;
        float f=1.0f;
        boolean bool=true;

        String str="1";
        EnumTest enumTest;

        switch (b){}
        switch (c){}
        switch (s){}
        switch (i){}
//        switch (l){}
//        switch (d){}
//        switch (f){}
//        switch (bool){}
        switch (str){}
//        switch (enumTest){}
    }
}
