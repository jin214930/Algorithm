#include <bits/stdc++.h>
using namespace std;

int n, lis[1000000], len, x;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    auto lowerPos = lower_bound(lis, lis + len, x);
    if (*lowerPos == 0) len++;
    *lowerPos = x;
  }

  cout << len << '\n';

  return 0;
}