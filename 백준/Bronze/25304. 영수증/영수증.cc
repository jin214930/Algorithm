#include <bits/stdc++.h>
using namespace std;

int n, x, a, b, sum;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> x >> n;
  for(int i = 0; i < n;i++) {
    cin >> a >> b;
    sum += a * b;
  }

  cout << (x == sum ? "Yes" : "No");

  return 0;
}