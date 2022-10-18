package a721.账户合并_并查集;

import java.util.*;

public class  AccountsMerge2{
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 邮箱对编号（这个编号记录总共有多少个不同的邮箱，并且通过这个编号去构建并查集）
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        // 邮箱对名称
        Map<String, String> emailToName = new HashMap<String, String>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }
        // 初始化并查集
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            // 获取同个账户下的第一个邮箱firstEmail
            String firstEmail = account.get(1);
            // 获取该邮箱对应的编号
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            // 将该邮箱与其他邮箱构建并查集
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                // 同一账户下的邮箱通过其对应的编号构建并查集
                uf.union(firstIndex, nextIndex);
            }
        }
        // 建立编号和邮箱之间的对应
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            // 获取邮箱对应的编号的根节点
            int index = uf.find(emailToIndex.get(email));// 因为多个编号有同一个根编号（账户），即一个账户有多个邮箱（编号）
            // 收集根节点下的所有emails
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            // 将邮箱进行排序
            Collections.sort(emails);
            // 获取账户名
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
