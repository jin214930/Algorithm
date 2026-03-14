#include <bits/stdc++.h>
using namespace std;

double n, a[1000];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n;
  double mx = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    mx = max(mx, a[i]);
  }

  double sum = 0;
  for (int i = 0; i < n; i++) {
    a[i] = a[i] / mx * 100;
    sum += a[i];
  }

  cout << sum / n;

  return 0;
}