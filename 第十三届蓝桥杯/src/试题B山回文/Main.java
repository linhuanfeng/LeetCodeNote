package 试题B山回文;

public class Main {
    public static void main(String[] args) {
        int ans=0;
        for (int i = 2022; i <=2022222022 ; i++) {
            if(isHuiwen(i))ans++;
        }
        System.out.println(ans);
//        System.out.println(isHuiwen(1233));
    }
    static boolean isHuiwen(int a){
        String str = String.valueOf(a);
        int i=0,j=str.length()-1;
        if(str.charAt(i)!=str.charAt(j))return false;
        int pre=str.charAt(i);
        i++;
        j--;
        while (i<j){
            if(str.charAt(i)!=str.charAt(j)||str.charAt(i)<pre){
                return false;
            }
            pre=str.charAt(i);
            i++;
            j--;
        }
        return true;
    }
}
