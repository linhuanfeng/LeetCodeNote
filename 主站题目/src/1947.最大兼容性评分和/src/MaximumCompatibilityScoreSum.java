public class MaximumCompatibilityScoreSum {
    public static void main(String[] args) {
        int[][] students={{0,0},{0,0},{0,0}};
        int[][] mentors={{1,1},{1,1},{1,1}};
        System.out.println(maxCompatibilitySum(students, mentors));
    }
    public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return dfs(0,0,0,students,mentors);
    }
    //total(总数):记录当前的匹配度，cnt（cur）:记录当前的位置，state（vis数组，又兼当当前下标）:记录用了被访问的下标
    public static int dfs(int total,int cnt,int state,int[][] students, int[][] mentors){
        int max=0;
        if(cnt==students.length){
            // 递归出口
            return total;
        }
        for (int i = 0; i < students.length; i++) {
            if((1<<i&state)!=0){
                // 如果已被访问，跳过
                continue;
            }
            // 深度搜索每一种情况，取最大值
            max=Math.max(max,dfs(total+calMatch(students[cnt],mentors[i]),cnt+1,state|(1<<i),students,mentors));
        }
        return max;
    }
    // 计算相似度
    public static int calMatch(int[] arr1,int[] arr2){
        int cnt=0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]==arr2[i]){
                cnt++;
            }
        }
        return cnt;
    }
}
