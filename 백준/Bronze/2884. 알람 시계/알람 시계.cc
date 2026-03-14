#include <bits/stdc++.h>
using namespace std;

int h, m;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> h >> m;
  if (m < 45) {
    m = m + 15;
    h--;
    if (h == -1) h = 23;
  } else
    m -= 45;

  cout << h << ' ' << m;

  return 0;
}