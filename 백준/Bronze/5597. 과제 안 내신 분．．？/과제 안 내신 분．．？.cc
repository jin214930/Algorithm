#include <bits/stdc++.h>
using namespace std;

int cnt[31];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  for (int i = 0; i < 28; i++) {
    int x;
    cin >> x;
    cnt[x]++;
  }

  for (int i = 1; i <= 30; i++) {
    if (!cnt[i]) cout << i << '\n';
  }

  return 0;
}