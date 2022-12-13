package 类._this;

public class Foo {
    class Bar {
        Foo getFoo() {
            return Foo.this;
        }
        Bar getBar(){
            return Bar.this;
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Bar bar = foo.new Bar();

        Foo foo2 = bar.getFoo();
        Bar bar2 = bar.getBar();

        System.out.println(foo==foo2); // true
        System.out.println(bar==bar2); // true
    }
}
