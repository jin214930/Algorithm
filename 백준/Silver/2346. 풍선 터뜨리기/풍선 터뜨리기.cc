#include <bits/stdc++.h>
using namespace std;

int n, x;
deque<pair<int, int>> dq;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    dq.push_back({i, x});
  }

  while (dq.size() != 1) {
    cout << dq.front().first << ' ';
    int tmp = dq.front().second;
    dq.pop_front();

    if (tmp < 0) {
      for (int i = 0; i < abs(tmp); i++) {
        dq.push_front(dq.back());
        dq.pop_back();
      }
    } else {
      for (int i = 0; i < abs(tmp) - 1; i++) {
        dq.push_back(dq.front());
        dq.pop_front();
      }
    }
  }

  cout << dq.front().first;

  return 0;
}