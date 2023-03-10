
import java.util.HashMap;

public class StringValueTest {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>() {{
            put('e', 1);
            put('f', 2);
        }};
        System.out.println(hashMap.get('e')); // 1
        new String();
        new Object();
        new StringBuilder();
    }
}
