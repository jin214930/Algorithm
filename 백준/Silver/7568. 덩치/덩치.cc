#include <bits/stdc++.h>
using namespace std;

int n, ans[50];
vector<pair<int, int>> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back({ a, b });
	}

	for (int i = 0; i < n - 1; i++) {
		for (int j = i + 1; j < n; j++) {
			if (v[i].first < v[j].first && v[i].second < v[j].second)
				ans[i]++;
			else if (v[i].first > v[j].first && v[i].second > v[j].second)
				ans[j]++;
		}
	}

	for (int i = 0; i < n; i++)
		cout << ans[i] + 1 << ' ';

	return 0;
}