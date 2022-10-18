package a49.字母异位词分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计数
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            int[] count=new int[26]; // 统计每个字母出现的此时，将字母和对应出现的次数拼接作为key
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i)-'a']++; // 统计每个字幕出现的次数
            }
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if(count[i]>0){
                    sb.append((char)('a'+i)); // 拼接字母 出现次数大于0的才拼接字母
                    sb.append(count[i]); // 拼接对应的次数
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}