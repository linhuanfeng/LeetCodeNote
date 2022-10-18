import java.util.TreeSet;

public class LongestWordInDictionary2 {

    public static void main(String[] args) {
        LongestWordInDictionary2 dictionary = new LongestWordInDictionary2();
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
            // 长度大于或等于已有的res才有判断下一步的必要
            if(s.length()>res.length()||s.length()==res.length()&&s.compareTo(res)<0){
                int len=s.length();
                boolean tk=true;
                for(int i=1;i<len;i++){
                    if(!treeSet.contains(s.substring(0,i))){// 判断是否由字典里的内容组成
                        tk=false;
                        break;
                    }
                }
                if(tk){
                    res=s;
                }
            }

        }
        return res;
    }
}
