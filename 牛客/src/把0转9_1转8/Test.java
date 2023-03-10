package 把0转9_1转8;

import static javafx.scene.input.KeyCode.T;

public class Test {
    public static void main(String[] args) {
        String str="a039";
        StringBuilder sb=new StringBuilder("");
        Test test = new Test();
        for (int i = 0; i < str.length(); i++) {
            sb.append(test.func(str.charAt(i)));
        }
        System.out.println(sb);
    }
    char func(char ch){
        if(ch>='0'&&ch<='9')
            return (char) ('9'-(ch-'0')); // a960
        return ch;
    }
}
