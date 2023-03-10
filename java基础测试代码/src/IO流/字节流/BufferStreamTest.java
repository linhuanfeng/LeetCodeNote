package IO流.字节流;

import java.io.*;

public class BufferStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("F:\\java_install\\java_projects\\leetcode\\java基础测试代码\\src\\java基础\\io\\cn.txt");
        BufferedInputStream bs = new BufferedInputStream(stream);
        byte[] bytes = new byte[10];
        int read = bs.read(bytes);
        System.out.println(new String(bytes));

        String path="F:\\java_install\\java_projects\\leetcode\\java基础测试代码\\src\\java基础\\io\\字节流\\vedio.txt";
        String path2="F:\\java_install\\java_projects\\leetcode\\java基础测试代码\\src\\java基础\\io\\字节流\\vedio-copy.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        char[] chars={'c'};
        for (int i = 0; i < 500000; i++) {
            // 一个字符不是两字节吗？写入 2*5000字节=10k左右
            bw.write(chars);
        }
        bw.flush();
        System.out.println(new File(path).length()); // 5000字节=5KB
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));


        // 使用缓冲流复制文件
        long begin4 = System.currentTimeMillis();
        method4(path,path2); // 2ms
        System.out.println("BufferedInputStream=>buffer缓冲区=>耗时："+(System.currentTimeMillis()-begin4));

        long begin3 = System.currentTimeMillis();
        method3(path,path2); // 12ms
        System.out.println("BufferedInputStream=>一个一个字节=>耗时："+(System.currentTimeMillis()-begin3));

        long begin2 = System.currentTimeMillis();
        method2(path,path2); // 3ms
        System.out.println("FileInputStream=>buffer缓冲区=>耗时："+(System.currentTimeMillis()-begin2));

        long begin1 = System.currentTimeMillis();
        method1(path,path2); // 1508
        System.out.println("FileInputStream=>一个一个字节=>耗时：耗时："+(System.currentTimeMillis()-begin1));
    }
    //方式4： 采用高效的流，一个多个字节的方式赋值
    private static void method4(String src, String dest) throws IOException {
        //1，指定数据源
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
        //2，指定目的地
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
        //3，读数据
        byte[] buffer = new byte[1024];
        int len = -1;
        while ( (len = in.read(buffer)) != -1) {
            //4,写数据
            out.write(buffer, 0, len);
        }
        //5，关闭流
        in.close();
        out.close();
    }

    //方式3： 采用高效的流，一次一个字节的方式复制
    private static void method3(String src, String dest) throws IOException {
        //1，指定数据源
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
        //2，指定目的地
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
        //3，读数据
        int ch = -1;
        while ((ch=in.read()) != -1) {
            //4，写数据
            out.write(ch);
        }
        //5，关闭流
        in.close();
        out.close();
    }

    //方式2： 采用基本的流，一个多个字节的方式赋值
    private static void method2(String src, String dest) throws IOException {
        //1，指定数据源
        FileInputStream in = new FileInputStream(src);
        //2，指定目的地
        FileOutputStream out = new FileOutputStream(dest);
        //3，读数据
        byte[] buffer = new byte[1024];
        int len = -1;
        while ( (len=in.read(buffer)) != -1) {
            //4，写数据
            out.write(buffer, 0, len);
        }
        //5，关闭流
        in.close();
        out.close();
    }

    //方式1： 采用基本的流，一次一个字节的方式复制
    private static void method1(String src, String dest) throws IOException {
        //1，指定数据源
        FileInputStream in = new FileInputStream(src);
        //2，指定目的地
        FileOutputStream out = new FileOutputStream(dest);
        //3，读数据
        int ch = -1;
        while (( ch=in.read()) != -1) {
            //4，写数据
            out.write(ch);
        }
        //5，关闭流
        in.close();
        out.close();
    }
}
