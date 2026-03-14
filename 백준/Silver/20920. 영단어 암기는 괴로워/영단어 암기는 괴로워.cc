#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<string> v;
map<string, int> mp;

bool cmp(string a, string b) {
	if (mp[a] == mp[b]) {
		if (a.size() == b.size())
			return a < b;
		return a.size() > b.size();
	}
	return mp[a] > mp[b];
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		string tmp;
		cin >> tmp;
		if (tmp.size() >= m) {
			if(!mp[tmp])
				v.push_back(tmp);
			mp[tmp]++;
		}
	}

	sort(v.begin(), v.end(), cmp);

	for (string s : v)
		cout << s << '\n';

	return 0;
}