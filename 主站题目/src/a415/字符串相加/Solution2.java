package a415.字符串相加;

/**
 * 采用双指针
 * 798
 * 232
 * temp 记录当前位的临时大小
 * carry 记录进位
 * res 记录结果
 * 时间：O(max(m,n))
 * 空间：O(1)
 */
class Solution2 {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1,j=num2.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while (i>=0||j>=0) {
            int n1=i>=0?num1.charAt(i)-'0':0; // 记录num1当前位的值，如果没有就设为0
            int n2=j>=0?num2.charAt(j)-'0':0;
            int temp=n1+n2+carry;
            carry=temp/10;
            sb.append(temp%10);
            i--;
            j--;
        }
        // 最多也就进一
        if(carry==1)sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.addStrings("1", "9"));
    }
}