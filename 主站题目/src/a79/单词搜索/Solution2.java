package a79.单词搜索;

/**
 * 性能更差
 */
public class Solution2 {
    public boolean exist(char[][] board, String word) {
        checked=new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, word.toCharArray(), 0)){
                    return true;
                }
            }
        }
        return false;
    }
    int[] dx={0,1,0,-1};
    int[] dy={1,0,-1,0};
    int[][] checked;
    boolean dfs(char[][] board,int x,int y,char[] word,int z){
        if(z==word.length-1){
            return board[x][y]==word[z];
        }
        if(board[x][y]==word[z]){
            checked[x][y]=1;
            for (int i = 0; i < 4; i++) {
                int tx=x+dx[i];
                int ty=y+dy[i];
                if(isOk(board, tx, ty, word, z+1)&&checked[tx][ty]==0) {
                    if (dfs(board, tx, ty, word, z + 1)) {
                        return true;
                    }
                }
            }
            checked[x][y]=0;
        }

        return false;
    }
    boolean isOk(char[][] board,int x,int y,char[] word,int z){
        if(x<0||x>=board.length||y<0||y>=board[0].length||z>=word.length||board[x][y]!=word[z]){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        char[][] board={{'a'},{'a'}};
        String word="aaa";
        System.out.println(solution.exist(board, word));
    }
}
