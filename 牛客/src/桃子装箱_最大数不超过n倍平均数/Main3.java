package 桃子装箱_最大数不超过n倍平均数;

import java.io.*;
import java.util.Arrays;

/**
 * 前缀和+二分
 * 二分选一个数，然后暴力判断
 *
 * 时间：O(n^2)
 * 空间：O(n) 前缀和减少重复计算
 */
// 100
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n=Integer.valueOf(s[0]),k=Integer.valueOf(s[1]);
        int[] arr=new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.valueOf(s[i]);
        }

        int left=0,right=n-1,ans=0;
        int[] preSum=new int[n+1];
        Arrays.sort(arr);
        // 前缀和
        for (int i = 1; i < n; i++) {
            preSum[i]+=preSum[i-1]+arr[i-1];
        }

        while (left<right){ // 对桃子个数进行二分，再暴力判断是否满足条件
            int m=(left+right)/2; // 假设最多m+1个桃子，遍历所有情况是否满足情况，如果满足，尝试m+2个桃子，否则m个桃子
            boolean flag=false;
            for (int i = 0; i < n-m; i++) {
                if(arr[i+m]<=1.0*(preSum[i+m+1]-preSum[i])/(m+1)*k){ // 最大值是否小于等于k倍平均数
                    flag=true;
                    break;
                }
            }
            if(flag){
                ans=m+1;
                left=m+1;
            }else {
                right=m-1;
            }
        }

        bw.write(ans+"");
        bw.flush();
    }
    /*
    二分+暴力枚举
    #include <bits/stdc++.h>
using namespace std;

int main() {
  using ll = long long;
  int n, k; cin >> n >> k;
  vector<int> v(n);
  for (int i = 0; i < n; i++) cin >> v[i];
  sort(v.begin(), v.end());
  vector<ll> preSum(n+1);
  for (int i = 1; i <= n; i++) {
    preSum[i] = preSum[i-1] + v[i-1];
  }
  auto ck = [&] (int m) -> bool {
    for (int i = 0; i < n-m+1; i++) {
      if (1.0*(preSum[i+m]-preSum[i])/m*k >= v[i+m-1]) {
        return true;
      }
    }
    return false;
  };
  int low = 1, high = n;
  int ans = 1;
  while (low <= high) {
    int m = (low+high)/2;
    if (!ck(m)) {
      high = m-1;
    } else {
      ans = m;
      low = m+1;
    }
  }
  cout << ans << endl;
  return 0;
}
     */
}
