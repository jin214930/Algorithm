#include <bits/stdc++.h>
using namespace std;

int t, n, m, tmp;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		vector<int> v;
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> tmp;
			v.push_back(tmp);
		}
		
		sort(v.begin(), v.end());

		cin >> m;
		for (int i = 0; i < m; i++) {
			cin >> tmp;
			if (binary_search(v.begin(), v.end(), tmp))
				cout << 1 << '\n';
			else
				cout << 0 << '\n';
		}
	}

	return 0;
}