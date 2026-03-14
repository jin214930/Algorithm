#include <bits/stdc++.h>
using namespace std;

int n, k, ans, cnt;
vector<pair<tuple<int, int, int>, int>> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		v.push_back({ {b, c, d}, a });
	}

	sort(v.rbegin(), v.rend());

	for (int i = 0; i < n; i++) {
		if (v[i].second == k)
			ans = i + 1;
	}
	for (int i = 0; i < ans - 1; i++) {
		if (v[i].first == v[ans - 1].first)
			cnt++;
	}

	cout << ans - cnt;

	return 0;
}