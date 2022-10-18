package a208.实现Trie前缀树;

/**
 * 时间：O(S),S为每次插入或搜索的字符串个数
 * 空间：O(26*s), 26为字符集个数，s为字符串个数
 */
class Trie {
    private Trie[] children = new Trie[26];
    private boolean isEnd;

    public Trie() {

    }

    public void insert(String word) {
        Trie[] curChildren = children;
        if (curChildren[word.charAt(0) - 'a'] == null)
            curChildren[word.charAt(0) - 'a'] = new Trie();
        for (int i = 0; i < word.length() - 1; i++) {
            curChildren = curChildren[word.charAt(i) - 'a'].children; // 其实处理的是下一个，保证腿粗循环的时候curChildren指向word最后一个元素的数组
            if (curChildren[word.charAt(i+1) - 'a'] == null) {
                curChildren[word.charAt(i+1) - 'a'] = new Trie();
            }
        }
        curChildren[word.charAt(word.length() - 1) - 'a'].isEnd = true;
    }

    public boolean search(String word) {
        Trie cur = children[word.charAt(0) - 'a'];
        if (cur == null)
            return false;
        for (int i = 0; i < word.length()-1; i++) {
            cur = cur.children[word.charAt(i+1) - 'a'];
            if (cur == null) {
                return false;
            }
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie cur = children[prefix.charAt(0) - 'a'];
        if (cur == null) {
            return false;
        }
        for (int i = 0; i < prefix.length()-1; i++) {
            cur = cur.children[prefix.charAt(i+1) - 'a'];
            if (cur == null) {
                return false;
            }
        }
        return true;
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