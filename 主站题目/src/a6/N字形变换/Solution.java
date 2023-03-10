package a6.N字形变换;

/**
 * 时间：O(n)字符串的长度，每个访问一次
 * 空间：O(n)临时存储字符串的长度
 */
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] arr=new StringBuilder[numRows];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=new StringBuilder(); // numRows为多少，数组行数就为多少
        }
        int k=0;
        // 模拟z字形走法
        while (k<s.length()){
            // 从上往下
            for (int i = 0; i < numRows; i++) {
                if(k>=s.length())break;
                arr[i].append(s.charAt(k++));
            }
            // 往上
            for (int i = numRows-2; i >0 ; i--) {
                if(k>=s.length())break;
                arr[i].append(s.charAt(k++));
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <numRows ; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
