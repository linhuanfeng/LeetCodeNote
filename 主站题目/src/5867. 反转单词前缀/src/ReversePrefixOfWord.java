import java.util.Arrays;

public class ReversePrefixOfWord {
    public static void main(String[] args) {
        reversePrefix("abcdefd",'d');
    }
    public static String reversePrefix(String word, char ch) {
        int fir=word.indexOf(ch);
        String t="";
        if(fir!=-1){
            char[] chars=word.toCharArray();
            for(int j=fir;j>=0;j--){
                t=t+chars[j];
            }
            t=t+word.substring(fir+1,word.length());
        }else{
            t=word;
        }
        System.out.println(t);
        return t;
    }
}
