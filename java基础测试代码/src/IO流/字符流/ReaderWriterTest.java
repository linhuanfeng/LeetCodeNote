package IO流.字符流;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileReader是InputStreamReader的子类
 */
public class ReaderWriterTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\java_install\\java_projects\\leetcode\\java基础测试代码\\src\\java基础\\io\\cn.txt");
        FileWriter wr = new FileWriter(file);
        for (int i = 0; i < 10; i++) {
            wr.write("asd你好");
        }
        // 这里一定要调用flush将缓冲区内容刷到目的地，否则下面fr读不到
        wr.flush();

        FileReader fr = new FileReader(file); // 指定文件不存在，报FileNotFoundException
        System.out.println(fr.getEncoding()); // 默认UTF8
        char[] chars = new char[4];
        int len=0;
        while ((len=fr.read(chars,0,chars.length))!=-1){
            System.out.println("len:"+len);
            System.out.println(chars);
        }

        wr.close(); // 关闭前会自动调用flush
        fr.close();
    }
}
