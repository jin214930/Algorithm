#include <bits/stdc++.h>
using namespace std;

int n, k;
queue<int> q;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n >> k;
  for (int i = 0; i < n; i++) q.push(i + 1);

  cout << '<';
  while (q.size() != 1) {
    for (int i = 0; i < k - 1; i++) {
      q.push(q.front());
      q.pop();
    }
    cout << q.front() << ", ";
    q.pop();
  }

  cout << q.front() << '>';

  return 0;
}