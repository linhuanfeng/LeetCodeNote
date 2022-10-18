package 类加载.继承instanceof是否相等;

public class Test {
    public static void main(String[] args) {
        Phone phone1=new Phone() {};
        Phone phone2=new AbstractPhone() {};
        Phone phone3=new Xiaomi();

        System.out.println(phone1 instanceof Phone); // true
        System.out.println(phone1 instanceof AbstractPhone); // false
        System.out.println(phone1 instanceof Xiaomi); // false

        System.out.println(phone2 instanceof Phone); // true
        System.out.println(phone2 instanceof AbstractPhone); // true
        System.out.println(phone2 instanceof Xiaomi); // false

        System.out.println(phone3 instanceof Phone); // true
        System.out.println(phone3 instanceof AbstractPhone); // true
        System.out.println(phone3 instanceof Xiaomi); // true
    }
}
interface Phone{}
abstract class AbstractPhone implements Phone{}
class Xiaomi extends AbstractPhone{}
