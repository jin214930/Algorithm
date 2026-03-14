#include <bits/stdc++.h>
using namespace std;

stack<int> st;
int n, c, x;

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n;
  while (n--) {
    cin >> c;
    switch (c) {
      case 1:
        cin >> x;
        st.push(x);
        break;
      case 2:
        if (st.size()) {
          cout << st.top() << '\n';
          st.pop();
        } else
          cout << -1 << '\n';
        break;
      case 3:
        cout << st.size() << '\n';
        break;
      case 4:
        cout << (st.empty() ? 1 : 0) << '\n';
        break;
      default:
        if (st.size())
          cout << st.top() << '\n';
        else
          cout << -1 << '\n';
        break;
    }
  }

  return 0;
}