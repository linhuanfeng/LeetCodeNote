package IO流.字节流;

import java.io.*;

public class BufferReaderTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\code\\leetcode\\测试\\src\\IO流\\cn.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        while (true) {
            String line = br.readLine();
            if(line==null){
                break;
            }
            System.out.println(line);
        }
    }
}
