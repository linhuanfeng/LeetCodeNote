package IO流.字符流;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 转换流（字符和字节的桥梁字符和字节的桥梁），是FileReader&FileWriter的父类
 *        OutputStreamWriter： 字符转字节
 *        InputStreamReader：  字节转字符
 * 父子类区别：父类可以指定编码，子类默认utf8

 */
public class OutputStreamWriterTest {
    public static void main(String[] args) throws IOException {
        String path="F:\\java_install\\java_projects\\leetcode\\java基础测试代码\\src\\java基础\\io\\转换流\\cn.txt";
        FileOutputStream fos = new FileOutputStream(path);
        //  创建一个可以字符流转为字节流的转换流对象
        OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.defaultCharset());
        // 根据字符编码把字符转为字节，再写到缓冲区中
        osw.write("12313你好");
        osw.close();
        fos.close();

        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis, Charset.defaultCharset());
        // 根据字符编码把字符转为字节，再写到缓冲区中
        char[] chars=new char[10];
        isr.read(chars);
        System.out.println(chars);
        isr.close();
        fis.close();
    }
}
