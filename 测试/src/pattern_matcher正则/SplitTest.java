package pattern_matcher正则;

/**
 * split最后一个分隔符直接去掉
 * 找到分割符返回分割数组，否则一律（空串）返回1
 */
public class SplitTest {
    public static void main(String[] args) {
        String str1="1,2,3,";
        String[] split1 = str1.split(",");
        System.out.println("size:"+split1.length); // 3
        for (int i = 0; i < split1.length; i++) {
            System.out.print(i+":"+split1[i]+"  "); // 0:1  1:2  2:3
        }
        System.out.println("\n===============");

        String str2=",1,2,3,";
        String[] split2 = str2.split(",");
        System.out.println("size:"+split2.length); // 4
        for (int i = 0; i < split2.length; i++) {
            System.out.print(i+":"+split2[i]+"  "); // 0:  1:1  2:2  3:3 保留了最前面的空串
        }
        System.out.println();

        String str3 = "";
        System.out.println(str3.split(",").length); // 1
        String str4 = "123";
        System.out.println(str4.split(",").length); // 1

        String str5="abc.beat.gane.";
        String regex="\\.\\s*";
        for (String s : str5.split(regex)) {
            System.out.print(s+" "); // abc beat gane
        }
    }
}
