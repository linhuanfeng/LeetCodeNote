package 老张的美数课;

public class Main2 {

/*
#include <bits/stdc++.h>
using namespace std;
int get_xor(long long x)
{
    int res = 0;
    while (x)
    {
        res ^= (x % 10);
        x /= 10;
    }
    return res;
}
int main()
{
    unordered_map<long long, vector<long long>> map;
    for (long long i = 0, r; i <= 70000; ++i)
    {
        r = get_xor(i);
        map[r].push_back(i);
    }
    int n;
    while (cin >> n)
    {
        vector<long long> L(n, 0), R(n, 0), Q(n, 0);
        for (int i = 0; i < n; ++i) cin >> L[i];
        for (int i = 0; i < n; ++i) cin >> R[i];
        for (int i = 0; i < n; ++i)
        {
            cin >> Q[i];
            int lindex = lower_bound(map[Q[i]].begin(), map[Q[i]].end(), L[i]) - map[Q[i]].begin();
            int rindex = lower_bound(map[Q[i]].begin(), map[Q[i]].end(), R[i]) - map[Q[i]].begin();
            cout<<rindex - lindex + 1<<" ";
        }
        cout<<endl;
    }
    return 0;
}
 */
    /*
    前缀和初始化。有个要注意的点是 t 大于等于16时可以直接输出0，因为 0-9 内的任意个数异或范围为 [0, 16)。
    总的来说两题都不难，即使想不到也能暴力过一部份。
    #include <bits/stdc++.h>
using namespace std;
int main() {
  vector<vector<int>> cnt(70001, vector<int>(20));
  cnt[0][0] = 1;
  for (int i = 1; i < 70001; i++) {
    int s = 0, tmp = i;
    while (tmp) {
      s ^= tmp % 10;
      tmp /= 10;
    }
    for (int j = 0; j < 16; j++) {
      cnt[i][j] = cnt[i-1][j]+(j==s);
    }
  }
  int n; cin >> n;
  vector<int> l(n), r(n), t(n);
  for (int i = 0; i < n; i++) cin >> l[i];
  for (int i = 0; i < n; i++) cin >> r[i];
  for (int i = 0; i < n; i++) cin >> t[i];

  for (int i = 0; i < n; i++) {
    if (t[i] >= 16) {
      cout << 0 << " ";
      continue;
    }
    cout << cnt[r[i]][t[i]] - (l[i] ? cnt[l[i]-1][t[i]] : 0) << " ";
  }
  cout << endl;
  return 0;
}
     */
}