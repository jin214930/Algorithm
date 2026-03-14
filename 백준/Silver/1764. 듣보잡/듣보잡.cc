#include <bits/stdc++.h>
using namespace std;

int n, m;
string s;
map<string, int> mp;
vector<string> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> s;
		mp[s]++;
	}
	for (int i = 0; i < m; i++) {
		cin >> s;
		mp[s]++;
	}

	for (auto i : mp) {
		if (i.second == 2)
			v.push_back(i.first);
	}

	cout << v.size() << '\n';
	for (string s : v)
		cout << s << '\n';

	return 0;
}