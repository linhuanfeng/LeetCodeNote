package IO流.字节流;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\java_install\\java_projects\\leetcode\\测试\\src\\java基础\\io\\StreamTest.txt");
        FileOutputStream fos = new FileOutputStream(file);
        for (int i = 0; i < 256; i++) {
            fos.write(String.valueOf(i).getBytes(Charset.defaultCharset()));
            if(i%10==0)
                fos.write("\r\n".getBytes());
        }
        // 默认是追加
        for (int i = 256; i < 512; i++) {
            fos.write(String.valueOf(i).getBytes(Charset.defaultCharset()));
        }
        fos.close();


        // ，默认new FileOutputStream是覆盖,可选第二个构造参数append,是否追加
//        FileOutputStream stream2 = new FileOutputStream(file);
        FileOutputStream fos2 = new FileOutputStream(file,true);
        fos2.write("1111".getBytes());
        FileInputStream fis = new FileInputStream(file);
        File file2 = new File("F:\\java_install\\java_projects\\leetcode\\测试\\src\\java基础\\io\\StreamTest.txt-copy");
        FileOutputStream fos3 = new FileOutputStream(file2); // 默认覆盖

        byte[] bytes=new byte[15];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            System.out.println("len:"+len);
            System.out.println(new String(bytes)); // 前面的空格还是会读出来

            // 利用缓冲区从一个文件复制到另一个文件
            fos3.write(bytes);
        }
        fos2.close();
    }
}
