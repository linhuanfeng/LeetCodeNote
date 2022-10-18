package 包装类;

public class test {
    public static void main(String[] args) {
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 =Integer.valueOf(59); // 走缓存
        Integer i04 = new Integer(59); // 堆中新建对象

        System.out.println(i01==i02); // true 自动拆箱比较。基本类型和包装类型比较时会自动拆装箱
        System.out.println(i01==i03); // true 走缓存。[-128,127]
        System.out.println(i03==i04); // false 缓存对象和新new的对象
    }
}
