package IO流.字符流.转换流;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader和FileWriter分别作为InputStreamReader和OutputStreamWriter的子类，使用更加便捷
 *
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fileReader=null;
        try {
//            FileInputStream fileInputStream = new FileInputStream("E:\\code\\leetcode\\java基础测试代码\\src\\java基础\\io\\字符流\\cn.txt");
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            fileReader = new FileReader("E:\\\\code\\\\leetcode\\\\java基础测试代码\\\\src\\\\java基础\\\\io\\\\字符流\\\\cn.txt");
            int c=' ';
            while ((c= fileReader.read())!=-1){
                System.out.print((char)c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileReader.close(); // 包装流内部会调用节点流进行关闭
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
