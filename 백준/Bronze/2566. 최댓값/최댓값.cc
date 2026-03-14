#include <bits/stdc++.h>
using namespace std;

int a, mx, y, x;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  for (int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {
      cin >> a;
      if (a > mx) {
        mx = a;
        y = i;
        x = j;
      }
    }
  }

  cout << mx << '\n';
  cout << y + 1 << ' ' << x + 1;

  return 0;
}