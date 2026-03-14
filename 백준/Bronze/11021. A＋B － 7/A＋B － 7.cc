#include <bits/stdc++.h>
using namespace std;

int t, a, b;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> t;
  for(int i = 1; i <=t;i++) {
    cin >> a>> b;
    cout << "Case #" << i << ": ";
    cout << a + b << '\n';
  }

  return 0;
}