package 生成随机字符串;

import java.util.*;

/**
 * 生成一个随机字符串数组，这些字符串是不一样的，每个字符串由字母和数字组成
 */
public class Solution {
    public String[] helper(int count, int length) {
        String[] ans = new String[count];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            while (true) {
                String randomString = getRandomString2(length);
                map.put(randomString, 1);
                if(map.size()==i+1){ // 如果size不等于i+1，说明跟之前重复了，因为hashMap会覆盖
                    ans[i]=randomString;
                    break;
                }
            }
        }
        return ans;
    }

    // random.nextInt(62)
    String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb;
        sb = new StringBuilder();
        for (int j = 0; j < length; j++) {
            sb.append(str.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    // Math.random() 0.0-1.0
    String getRandomString2(int length) {
        Random random = new Random();
        StringBuilder sb;
        sb = new StringBuilder();
        for (int j = 0; j < length; j++) {
            int index = random.nextInt(3);
            switch (index){
                case 0:
                    sb.append((char)( random.nextInt(26)+'A'));
                    break;
                case 1:
                    sb.append((char)( random.nextInt(26)+'a'));
                    break;
                case 2:
                    sb.append(random.nextInt(10));
                    break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String s : solution.helper(4, 10)) {
            System.out.println(s);
        }
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.shuffle(list); // 列表洗牌
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
