package a208.实现Trie前缀树.小优化;

/**
 * 前缀树数据结构：
 * 一个指针数组+isEnd标记
 * [a]          [b]         [c]..
 * [a][b][c]..  [a][b][c]..   [a][b][c]..
 * 指针数组表示首元素，isEnd标记是否有这个结尾的字符串
 *
 * 时间：O(S),S为每次插入或搜索的字符串个数
 * 空间：O(26*s), 26为字符集个数，s为字符串个数
 */
class Trie {
    private Trie[] children = new Trie[26];
    private boolean isEnd;

    public Trie() {

    }

    public void insert(String word) {
        Trie node=this;
        for (int i = 0; i < word.length(); i++) {
            int index=word.charAt(i)-'a';
            if(node.children[index]==null){
                node.children[index]=new Trie(); // 申请空间表示存在该元素
            }
            node=node.children[index];
        }
        node.isEnd=true; // 标记word字符串的结束
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node==null?false:node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node!=null;
    }
    private Trie searchPrefix(String pref){
        Trie node=this;
        for (int i = 0; i < pref.length(); i++) {
            int index=pref.charAt(i)-'a';
            if(node.children[index]==null){ // 表示该路径元素不存在
                return null;
            }
            node=node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        /**
         * ["Trie","insert","search","search","startsWith","insert","search"]
         * [[],    ["apple"],["apple"],["app"],["app"],     ["app"],["app"]]
         */
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }
}