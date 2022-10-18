public class Solution2 {
    public String replaceSpace(String s) {
        int len=s.length();
        char[] chars = new char[len* 3];
        int j=0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c==' '){
                chars[j++]='%';
                chars[j++]='2';
                chars[j++]='0';
            }else {
                chars[j++]=c;
            }
        }
        return new String(chars,0,j);
    }
}