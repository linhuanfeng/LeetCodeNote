package 哔哩哔哩2021校园招聘后端开发方向笔试卷A.算24点;

public class Solution {
    public boolean Game24Points(int[] arr) {
        // write code here
        boolean[] vis = new boolean[4];
        for (int i = 0; i < 4; i++) {
            vis[i]=true;
            if(dfs(arr,arr[i],vis,1)){
                return true;
            }
            vis[i]=false;
        }
        return false;
    }

    boolean dfs(int[] arr, int total, boolean[] vis,int count) {
        if(count>3){
            if(total==24){
                return true;
            }else {
                return false;
            }
        }
        for (int i = 0; i < 4; i++) {
            if(!vis[i]){
                vis[i]=true;
                dfs(arr, total, vis, count);
                if(dfs(arr, total - arr[i], vis,count+1))return true;
                vis[i]=false;
                vis[i]=true;
                if(dfs(arr, total + arr[i], vis,count+1))return true;
                vis[i]=false;
                vis[i]=true;
                if(dfs(arr, total * arr[i], vis,count+1))return true;
                vis[i]=false;
                if (total % arr[i] == 0) {
                    vis[i]=true;
                    if(dfs(arr, total / arr[i], vis,count+1))return true;
                    vis[i]=false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr={2,5,8,10};
        System.out.println(solution.Game24Points(arr));
    }
}
