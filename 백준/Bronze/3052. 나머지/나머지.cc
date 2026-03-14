#include <bits/stdc++.h>
using namespace std;

int cnt[42], ans;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  for (int i = 0; i < 10; i++) {
    int x;
    cin >> x;
    cnt[x % 42]++;
  }

  for (int i = 0; i < 42; i++) {
    if (cnt[i]) ans++;
  }

  cout << ans;

  return 0;
}