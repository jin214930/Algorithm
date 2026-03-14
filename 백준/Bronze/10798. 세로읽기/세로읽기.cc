#include <bits/stdc++.h>
using namespace std;

char a[5][18];
string s;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  for (int i = 0; i < 5; i++) {
    cin >> s;
    for (int j = 0; j < s.size(); j++) a[i][j] = s[j];
  }

  for (int i = 0; i < 18; i++) {
    for (int j = 0; j < 5; j++)
      if (a[j][i]) cout << a[j][i];
  }

  return 0;
}