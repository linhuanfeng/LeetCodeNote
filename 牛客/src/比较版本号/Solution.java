package 比较版本号;

/**
 * 字符切割，使用Integre.valueOf()进行解析（会自动去掉前导0），如果是不存在该修订号则视为0
 *
 * 时间：O(max(n,m)) 版本号的长度
 * 空间：O(n)
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\."),
        split2=version2.split("\\.");

        for (int i = 0; i < split1.length || i < split2.length; i++) {
            int x=0,y=0;
            if(i<split1.length){
                x=Integer.valueOf(split1[i]);
            }
            if(i<split2.length){
                y=Integer.valueOf(split2[i]);
            }
            if(x>y){
                return 1;
            } else if (x<y) {
                return -1;
            }
        }
        return 0;
    }
}
