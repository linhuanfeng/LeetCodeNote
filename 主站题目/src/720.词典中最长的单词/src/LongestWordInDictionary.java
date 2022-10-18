import java.util.TreeSet;

public class LongestWordInDictionary {

    public static void main(String[] args) {
        LongestWordInDictionary dictionary = new LongestWordInDictionary();
        String[] words={"a", "zaa","cd","ef","banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(dictionary.longestWord(words));
    }
    public String longestWord(String[] words) {

        if(words.length==1){
            return words[0];
        }
        TreeSet<String> treeSet = new TreeSet<>();
        String res="";

        for (String word : words) {
            treeSet.add(word);
        }
        for (String s : words) {
            int len=s.length();
            boolean tk=true;
            for(int i=1;i<len;i++){
                if(!treeSet.contains(s.substring(0,i))){// 判断是否由字典里的内容组成
                    tk=false;
                    break;
                }
            }
            if(tk){
                if(s.length()>res.length()){
                    res=s;
                }else if(s.length()==res.length()){
                    if(s.compareTo(res)<0){
                        res=s;
                    }
                }
            }
        }
        return res;
    }
}
