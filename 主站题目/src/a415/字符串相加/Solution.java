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
class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length(),j=num2.length();
        int k=0,carry=0;
        StringBuilder sb=new StringBuilder();
        while (k<i&&k<j) {
            int temp=num1.charAt(i-k-1)-'0'+num2.charAt(j-k-1)-'0'+carry;
            carry=temp/10;
            sb.append(temp%10);
            k++;
        }
        if(k==i&&k<j){
            for (int l = k; l <j ; l++) {
                int temp=num2.charAt(j-l-1)-'0'+carry;
                carry=temp/10;
                sb.append(temp%10);
            }
        }else if(k==j&&k<i){
            for (int l = k; l <i ; l++) {
                int temp=num1.charAt(i-l-1)-'0'+carry;
                carry=temp/10;
                sb.append(temp%10);
            }
        }
        if(carry!=0)sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("1", "9"));
    }
}