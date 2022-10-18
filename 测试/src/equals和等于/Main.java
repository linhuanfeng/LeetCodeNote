package equals和等于;

public class Main {
	public static void main(String[] args) {
		// 基本数据类型（byte，short，char，int，float，double，long，boolean）来说，他们在常量池存储起来的，对于这样的字符串
		// "123" 也是相同的道理，在常量池中，一个常量只会对应一个地址，因此不管是再多的 123,"123"
		// 这样的数据都只会存储一个地址，所以所有他们的引用都是指向的同一块地址，因此基本数据类型
		// 和String常量是可以直接通过==来直接比较的。

		// ==和equals都是判断是否是同一个引用
		// 所以字符串还是用.compareto 去判断是否相等

		String str = "abc";
		String t = str.substring(0, 1);
		char c = 'a';
		String str2 = "a";
		String str3 = "a";
		if (String.valueOf(c) == t) {
			System.out.println("1");
		}
		if (String.valueOf(c) == str2) {
			System.out.println("2");
		}
		if (t == str2) {
			System.out.println("3");
		}
		if (str2 == str3) { // 只有这个能够输出,字符常量的内存只有一个，在常量池里面
			System.out.println("4");
		}
	}
}
