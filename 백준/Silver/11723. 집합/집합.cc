#include <bits/stdc++.h>
using namespace std;

int m, x, s;
string cmd;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> m;

	while (m--) {
		cin >> cmd;
		if (cmd == "all")
			s = ~(1 << 21);
		else if (cmd == "empty")
			s = 0;
		else {
			cin >> x;
			if (cmd == "add")
				s |= 1 << x;
			else if (cmd == "remove")
				s &= ~(1 << x);
			else if (cmd == "check")
				cout << (s & (1 << x) ? 1 : 0) << '\n';
			else
				s ^= 1 << x;
		}
	}
	

	return 0;
}