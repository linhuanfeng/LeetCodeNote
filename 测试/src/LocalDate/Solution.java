package LocalDate;

import java.time.LocalDate;
import java.util.*;

/**
 * ["20th Oct 2051","20th Oct 2051","29th Feb 2004","2nd Jan 2022"]
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 日期字符串数组一年中的几天求和
     * @param dates string字符串一维数组 日期字符串数组
     * @return int整型
     */
    public int dateArraysSum (String[] dates) {
        Map<String,Integer> map=new HashMap<>();
        Map<String,String> map2=new HashMap<>();
        map.put("Jan",1);
        map.put("Feb",2);
        map.put("Mar",3);
        map.put("Apr",4);
        map.put("May",5);
        map.put("Jun",6);
        map.put("Jul",7);
        map.put("Aug",8);
        map.put("Sep",9);
        map.put("Oct",10);
        map.put("Nov",11);
        map.put("Dec",12);
        // write code here
        int ans=0;
        for (String date : dates) {
            if(!map2.containsKey(date)){
                String[] str=date.split(" ");
                ans+=LocalDate.of(Integer.valueOf(str[2]), map.get(str[1]),Integer.valueOf(str[0].substring(0,str[0].length()-2)) ).getDayOfYear();
                map2.put(date,"");
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dateArraysSum(new String[]{"20th Oct 2051","20th Oct 2051","29th Feb 2004","2nd Jan 2022"}));
    }
}