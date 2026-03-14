#include <bits/stdc++.h>
using namespace std;

int n, m, a[101];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n >> m;
  for (int i = 1; i <= n; i++) a[i] = i;
  while (m--) {
    int b, c;
    cin >> b >> c;
    swap(a[b], a[c]);
  }

  for (int i = 1; i <= n; i++) cout << a[i] << ' ';

  return 0;
}