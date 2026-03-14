#include <bits/stdc++.h>
using namespace std;

int n, m, ans;
set<string> s;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	while (n--) {
		string tmp;
		cin >> tmp;
		s.insert(tmp);
	}

	while (m--) {
		string tmp;
		cin >> tmp;
		if (s.find(tmp) != s.end())
			ans++;
	}

	cout << ans;
	
	return 0;
}