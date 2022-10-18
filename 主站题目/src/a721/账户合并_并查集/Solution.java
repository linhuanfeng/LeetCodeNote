package a721.账户合并_并查集;

import java.util.*;

/**
 * 哈希表+并查集
 *
 * 不同邮箱的账户名称可能相同，但同个邮箱只对应一个账户
 * 假设一个邮箱地址对应一个编号，对编号进行并查集，
 * 同个账户下（["John", "johnsmith@mail.com", "john00@mail.com"]）的邮箱编号进行合并
 * 遍历所有的账户列表，对邮箱编号进行合并，此时不同列表的邮箱通过编号进会行合并，即实现了账户合并
 * 结果处理，对同个并集的邮箱进行放在同个list中
 *
 * 数据预处理，
 * 一个map存邮箱对编号emailToIndex，
 * 一个map存邮箱对账户emailToAccount，
 * 一个map存并集老大索引对应的邮箱集合（数据处理阶段）indexToEmails
 *
 * 时间：O(nlogn) n是邮箱的个数，对每个邮箱进行并查集合并或查找，看作是logn
 * 空间：O(n) 存储邮箱
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> emailToIndex=new HashMap<>(); // 邮箱对编号
        Map<String,String> emailToAccount=new HashMap<>(); // 邮箱对账户

        int accountSize=0; // 邮箱数目
        // 数据处理
        for (List<String> account : accounts) {
            String accountName=account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email=account.get(i);
                if(!emailToIndex.containsKey(email)){ // 相同邮箱只会存一次
                    emailToIndex.put(email,accountSize++);
                    emailToAccount.put(email,accountName);
                }
            }
        }

        // 构造邮箱编号的并查集
        UnionFind unionFind = new UnionFind(accountSize);
        for (List<String> account : accounts) {
            int firstIndex=emailToIndex.get(account.get(1)); // 使用每个账户的第一个邮箱构建并集
            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                unionFind.compose(firstIndex,emailToIndex.get(email));
            }
        }
        // 将同个并集的邮箱放在一起
        Map<Integer,List<String>> indexToEmails=new HashMap<>(); // 存并集老大索引对应的邮箱集合
        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            Integer index = entry.getValue();
            int father=unionFind.find(index); // 并集老大
            List<String> emails = indexToEmails.getOrDefault(father, new ArrayList<>());
            emails.add(entry.getKey());
            indexToEmails.put(father,emails);
        }
        // 结果处理
        List<List<String>> ans=new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails); // 同个账户的邮箱使用ascii码进行排序
            List<String> list=new ArrayList<>();
            list.add(emailToAccount.get(emails.get(0)));
            list.addAll(emails);
            ans.addAll(Collections.singleton(list));
        }
        return ans;
    }
    class UnionFind{
        int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i]=i;
            }
        }
        void compose(int i,int j){
            parent[find(i)]=find(j);
        }
        int find(int i){
            if(parent[i]!=i){
                return find(parent[i]);
            }
            return i;
        }
    }

    public static void main(String[] args) {
        String[] arr1={"John","johnsmith@mail.com","john_newyork@mail.com"};
        String[] arr2={"John","johnsmith@mail.com","john00@mail.com"};
        String[] arr3={"Mary","mary@mail.com"};
        String[] arr4={"John","johnnybravo@mail.com"};
        List<List<String>> accounts=new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();
        for (String s : arr1) {
            list1.add(s);
        }
        for (String s:arr2){
            list2.add(s);
        }
        for (String s:arr3){
            list3.add(s);
        }
        for (String s : arr4) {
            list4.add(s);
        }
        accounts.add(list1);
        accounts.add(list2);
        accounts.add(list3);
        accounts.add(list4);
        Solution solution = new Solution();
        for (List<String> strings : solution.accountsMerge(accounts)) {
            System.out.println(strings);
        }
    }
}