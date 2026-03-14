#include <bits/stdc++.h>
using namespace std;

int a, b, c;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> a >> b >> c;
  a += c / 60;
  b += c % 60;
  if (b >= 60) {
    a++;
    b -= 60;
  }
  if (a >= 24) a -= 24;
  cout << a << ' ' << b;

  return 0;
}