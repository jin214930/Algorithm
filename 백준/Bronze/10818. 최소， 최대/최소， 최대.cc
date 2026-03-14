#include <bits/stdc++.h>
using namespace std;

int n, a[1000001];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i];

  sort(a, a + n);
  cout << a[0] << ' ' << a[n - 1];

  return 0;
}