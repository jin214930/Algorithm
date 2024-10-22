#include <bits/stdc++.h>
using namespace std;

string s, t;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> s >> t;
  while (t.size() != s.size()) {
    if (t.back() == 'A')
      t.pop_back();
    else {
      t.pop_back();
      reverse(t.begin(), t.end());
    }
  }

  cout << (s == t ? 1 : 0);

  return 0;
}