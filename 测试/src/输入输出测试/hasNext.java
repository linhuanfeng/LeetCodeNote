package 输入输出测试;

import java.util.Scanner;

/**
 * hasNext回车也结束不了，会一直阻塞
 *      * Returns true if this scanner has another token in its input.
 *      * This method may block while waiting for input to scan.
 *      * The scanner does not advance past any input.
 */
public class hasNext {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(scanner.nextInt());
        }
    }
}
