#include <bits/stdc++.h>
using namespace std;

int n, m, b, c, a[100];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n >> m;
  for (int i = 0; i < n; i++) a[i] = i + 1;

  while (m--) {
    cin >> b >> c;
    b--;
    reverse(a + b, a + c);
  }

  for (int i = 0; i < n; i++) cout << a[i] << ' ';

  return 0;
}