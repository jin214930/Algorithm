#include <bits/stdc++.h>
using namespace std;

int n, x, c;
deque<int> dq;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n;

  while (n--) {
    cin >> c;
    switch (c) {
      case 1:
        cin >> x;
        dq.push_front(x);
        break;
      case 2:
        cin >> x;
        dq.push_back(x);
        break;
      case 3:
        if (dq.size()) {
          cout << dq.front() << '\n';
          dq.pop_front();
        } else
          cout << -1 << '\n';
        break;
      case 4:
        if (dq.size()) {
          cout << dq.back() << '\n';
          dq.pop_back();
        } else
          cout << -1 << '\n';
        break;
      case 5:
        cout << dq.size() << '\n';
        break;
      case 6:
        cout << (dq.empty() ? 1 : 0) << '\n';
        break;
      case 7:
        cout << (dq.size() ? dq.front() : -1) << '\n';
        break;
      default:
        cout << (dq.size() ? dq.back() : -1) << '\n';
        break;
    }
  }

  return 0;
}