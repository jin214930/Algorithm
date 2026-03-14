#include <bits/stdc++.h>
using namespace std;

int n, m, cnt;
vector<int> ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		int p, l, tmp;
		cin >> p >> l;
		vector<int> v;
		for (int j = 0; j < p; j++) {
			cin >> tmp;
			v.push_back(tmp);
		}
		if (p < l)
			ans.push_back(1);
		else {
			sort(v.rbegin(), v.rend());
			ans.push_back(v[l - 1]);
		}
	}
	
	sort(ans.begin(), ans.end());
	for (int i : ans) {
		if (m >= i) {
			cnt++;
			m -= i;
		}
		else
			break;
	}

	cout << cnt;

	return 0;
}