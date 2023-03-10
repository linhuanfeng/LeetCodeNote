import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateTest {
    public static void main(String[] args) {
        System.out.println(new Date()); // Wed Oct 27 19:22:59 CST 2021
        System.out.println(new java.sql.Date(System.currentTimeMillis())); // 2021-10-27
        System.out.println(new SimpleDateFormat("YYYY-mm-dd_HH:mm:ss").format(new Date())); // 2021-21-23_19:21:37
        System.out.println("=====================");
        System.out.println(System.currentTimeMillis()); // 1635333646903
    }
}
