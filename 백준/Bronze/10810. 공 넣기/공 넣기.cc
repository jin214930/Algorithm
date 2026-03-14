#include <bits/stdc++.h>
using namespace std;

int n, m, a[101];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n >> m;
  while (m--) {
    int b, c, d;
    cin >> b >> c >> d;
    for (int i = b; i <= c; i++) a[i] = d;
  }

  for (int i = 1; i <= n; i++) cout << a[i] << ' ';

  return 0;
}