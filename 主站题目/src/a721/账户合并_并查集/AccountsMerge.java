package a721.账户合并_并查集;

import java.util.*;

public class AccountsMerge {

    // 错误；没按ascci码排序
    public static void main(String[] args) {

        String a="john00@mail.com";
        String b="john_newyork@mail.com";
        String c="johnsmith@mail.com";
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(c));

        String[] arr={"John", "johnsmith@mail.com", "john00@mail.com"};
        String[] arr2={"John", "johnnybravo@mail.com"};
        String[] arr3={"John", "johnsmith@mail.com", "john_newyork@mail.com"};
        List<List<String>> accounts=new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        for (String s : arr) {
            list.add(s);
        }
        for (String s:arr2){
            list2.add(s);
        }
        for (String s:arr3){
            list3.add(s);
        }
        accounts.add(list);
        accounts.add(list2);
        accounts.add(list3);
        accountsMerge(accounts);

    }
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<Integer,List<Integer>> tMap = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for(int j=i+1;j<accounts.size();j++){
                if(accounts.get(i).get(0).equals(accounts.get(j).get(0))){//是否是同一个名称
                    Set<String> tSet= new HashSet<>();
                    for (String account : accounts.get(i)) {
                        tSet.add(account);
                    }
                    for (String account : accounts.get(j)) {
                        tSet.add(account);
                    }
                    if(tSet.size()<accounts.get(i).size()+accounts.get(j).size()-1){// 判断是否有相同的邮箱
                        if(!tMap.containsKey(i)){
                            List<Integer> list = tMap.get(i);
                            if(list!=null){
                                list.add(j);
                            }else{
                                list=new ArrayList<>();
                                list.add(j);
                                tMap.put(i,list);
                            }
                        }
                    }
                }
            }
        }
//        System.out.println(tMap);

        Map<String,Integer> tempMap=new TreeMap<>();

        List<List<String>> ans=new ArrayList<>();
        int[] iarr=new int[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            if(!tMap.containsKey((Integer) i)){
                if(iarr[i]==0){
                    ans.add(accounts.get(i));
                }
            }else{
                List<Integer> list = tMap.get(i);
                Set<String> set = new TreeSet<>();
                String name=accounts.get(i).get(0);
                for(int j=1;j<accounts.get(i).size();j++){
                    set.add(accounts.get(i).get(j));
                }
                for (Integer integer : list) {
                    iarr[integer]=1;
                    for (int j=1;j<accounts.get(integer).size();j++) {
                        set.add(accounts.get(integer).get(j));
                    }
                }
                List list2=new ArrayList();
                list2.add(name);
                tempMap.put(name,i);
                for (String s : set) {
                    list2.add(s);
                }
                ans.add(list2);
            }
        }


        System.out.println(ans);

        List<List<String>> ans2=new ArrayList<>();

        tempMap.forEach((key,value)->{
            for (List<String> an : ans) {
                if(ans.get(0).equals(key)){
                    ans2.add(ans.get(value));
                }
            }
        });

        System.out.println(ans);
        return ans2;
    }
}
