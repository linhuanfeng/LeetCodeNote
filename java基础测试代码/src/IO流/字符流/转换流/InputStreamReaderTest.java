package IO流.字符流.转换流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流
 * InputStreamReader:从字节流转为字符流
 *
 * 关闭顺序：
 * 一般是先打开的后关闭
 * 先关闭处理流。再关闭节点流，因为处理流使用的是装饰着默认，实际会调用关闭节点流
 * 有依赖关系，比如a依赖b,那么先关闭a
 */
public class InputStreamReaderTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader=null;
        try {
            fileInputStream = new FileInputStream("E:\\code\\leetcode\\java基础测试代码\\src\\java基础\\io\\字符流\\cn.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            int c=' ';
            while ((c= inputStreamReader.read())!=-1){
                System.out.print((char)c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                inputStreamReader.close(); // 包装流内部会调用节点流进行关闭
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
