package 剑指Offer48.最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        // 使用双端队列实现华滑动窗口
        Queue<Character> queue=new LinkedList<>();
        for (int i = s.length()-1; i >=0 ; i--) {
            if(queue.contains(s.charAt(i))){
                if(queue.size()>res){
                    res=queue.size();
                }
                while (queue.size()!=0){
                    Character head = queue.poll();
                    if(head.charValue()==s.charAt(i)){
                        break;
                    }
                }
            }
            queue.offer(s.charAt(i));
        }
        if(queue.size()>res){
            res=queue.size();
        }
        return res;
    }
}
