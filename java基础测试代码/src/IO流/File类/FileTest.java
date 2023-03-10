package IO流.File类;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class FileTest {
    public static void main(String[] args) {
        String pathName="F:\\java_install\\java_projects\\leetcode\\java基础测试代码\\src\\构造方法测试\\java基础\\Variable.java";
        File file = new File(pathName);
        System.out.println(file); // F:\java_install\java_projects\leetcode\java基础测试代码\src\构造方法测试\java基础\Variable.java
        System.out.println(file.getName()); // Variable.java
        System.out.println(file.getTotalSpace());  // 37178261504
        System.out.println(file.getFreeSpace());   // 12475543552
        System.out.println(file.getUsableSpace()); // 12475543552
        System.out.println(file.getParent());      // F:\java_install\java_projects\leetcode\java基础测试代码\src\构造方法测试\java基础
        System.out.println(file.getParentFile());  // F:\java_install\java_projects\leetcode\java基础测试代码\src\构造方法测试\java基础
        // 获取长度、
        System.out.println(file.length()); // 1223 字节
        System.out.println(file.canExecute()); // true
        System.out.println(file.canRead()); // true
        System.out.println(file.canWrite()); // true
//        for (String s : file.list()) { // 空指针异常
//            System.out.print(s+" ");
//        }
        File file2 = new File("F:\\java_install\\java_projects\\leetcode\\java基础测试代码\\src\\构造方法测试\\java基础");
        for (String s : file2.list()) { // 列出路径下的所有文件 FileTest.java Variable.java
            System.out.print(s+" ");
        }
        System.out.println();

        File file3 = new File(file2, "Variable.java");
        System.out.println(file2); // F:\java_install\java_projects\leetcode\java基础测试代码\src\构造方法测试\java基础\Variable.java

        File file4 = new File("./test.txt"); // ./当前项目之下
        try {
            boolean b = file4.createNewFile(); // 没有才创建
            System.out.println(b); //
        } catch (IOException e) {
            e.printStackTrace();
        }
//        boolean delete = file4.delete(); // 注意不走回收站
//        System.out.println(delete); // 存在则删除并返回true
        System.out.println(file4.exists()); // true

        File file5 = new File("/mydir/dir2"); // /在根盘
        boolean mkdir = file5.mkdir(); // 如果当前目录dir2的父目录不存在，则创建失败
        System.out.println(mkdir); // false
        boolean mkdirs = file5.mkdirs(); // 级联创建父目录
        System.out.println(mkdirs); // true
        boolean delete = file5.delete();
        System.out.println(delete);

        File file6 = new File("F:\\java_install\\java_projects\\leetcode\\java基础测试代码\\src\\构造方法测试");
        String[] list = file6.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        for (String s : list) {
            System.out.print(s+" "); // Main.java Test2.java
        }
        System.out.println();
        File[] files = file6.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        for (File file1 : files) {
            System.out.print(file1+" "); // F:\java_install\java_projects\leetcode\java基础测试代码\src\构造方法测试\java基础 F:\java_install\java_projects\leetcode\java基础测试代码\src\构造方法测试\父子类加载顺序
        }
        System.out.println();
//        Arrays
//        Map
//        Collection
//        TreeSet
        AtomicInteger integer = new AtomicInteger(1);
        System.out.println(integer.addAndGet(2)); // 3 添加指定元素并返回
        System.out.println(integer.getAndIncrement()+" "+integer); // 3 4
    }
}
