#include <bits/stdc++.h>
using namespace std;

int n, ans;
vector<pair<int, int>> v;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n;
  for (int i = 0; i < n; i++) {
    int sm, sd, em, ed;
    cin >> sm >> sd >> em >> ed;
    v.push_back({sm * 100 + sd, em * 100 + ed});
  }
  sort(v.begin(), v.end());
  int s = 301, e = 1130, idx = 0;
  while (true) {
    priority_queue<int> pq;
    while(idx < n && v[idx].first <= s) 
      pq.push(v[idx++].second);
    if(pq.empty()) {
      cout << 0;
      return 0;
    }
    int tmp = pq.top();
    ans++;
    if(tmp > e)
      break;
    s = tmp;
  }
  cout << ans;

  return 0;
}
