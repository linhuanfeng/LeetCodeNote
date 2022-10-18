package IO流.字符流;

import java.io.*;

public class BufferReaderTest {
    public static void main(String[] args) throws IOException {
        String path="F:\\java_install\\java_projects\\leetcode\\测试\\src\\java基础\\io\\字符流\\vedio.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (int i = 0; i < 5; i++) {
            bw.write("sdsada你好");
            bw.write("\n\r");
        }
        bw.flush();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String str="";
        while ((str=br.readLine())!=null){
            System.out.print(str);
        }
    }

}
