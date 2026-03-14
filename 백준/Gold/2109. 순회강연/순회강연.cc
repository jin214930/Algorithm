#include <bits/stdc++.h>
using namespace std;

int n, p, d, ans;
vector<int> v[10001];
priority_queue<int> pq;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> p >> d;
    v[d].push_back(p);
  }

  for (int i = 10000; i >= 1; i--) {
    if (v[i].size()) {
      for (int j : v[i]) pq.push(j);
    }
    if (pq.size()) {
      ans += pq.top();
      pq.pop();
    }
  }

  cout << ans;

  return 0;
}