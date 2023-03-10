package IO流.字符流.转换流;

import java.io.*;

/**
 * 转换流
 * OutputStreamWriter:从字符流转为字节流
 */
public class OutputStreamWriterTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileInputStream = new FileInputStream("E:\\code\\leetcode\\java基础测试代码\\src\\java基础\\io\\字符流\\cn.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close(); // 先打开的晚关闭
                bufferedReader.close(); // a依赖b,那么先关闭a
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
