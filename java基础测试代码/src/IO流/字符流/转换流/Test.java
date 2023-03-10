package IO流.字符流.转换流;

import java.io.*;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        String path="E:\\code\\leetcode\\java基础测试代码\\src\\IO流\\字符流\\cn.txt";

        FileInputStream fis1 = new FileInputStream(new File(path));
        FileInputStream fis2 = new FileInputStream(path);
//        new BufferedReader(new FileInputStream(path)) // 编译出错，得接受reader,需要使用FileInputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        System.out.println(fis1);
        System.out.println(fis2);
        System.out.println(br);
    }
}
