#include <bits/stdc++.h>
using namespace std;

int n, m, a[100][100], b[100][100];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) cin >> a[i][j];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) cin >> b[i][j];
  }

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) cout << a[i][j] + b[i][j] << ' ';
    cout << '\n';
  }
  return 0;
}