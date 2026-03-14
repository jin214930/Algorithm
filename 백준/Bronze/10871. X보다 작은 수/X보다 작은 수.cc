#include <bits/stdc++.h>
using namespace std;

int n, x;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n >> x;
  for (int i = 0; i < n; i++) {
    int tmp;
    cin >> tmp;
    if (tmp < x) cout << tmp << ' ';
  }

  return 0;
}