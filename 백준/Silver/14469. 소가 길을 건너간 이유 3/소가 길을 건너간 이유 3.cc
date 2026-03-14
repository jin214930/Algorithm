#include <bits/stdc++.h>
using namespace std;

int n, x, y, ans;
vector<pair<int, int>> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	while (n--) {
		cin >> x >> y;
		v.push_back({ x, y });
	}

	sort(v.begin(), v.end());

	for (auto i : v) {
		if (i.first > ans)
			ans = i.first;
		ans += i.second;
	}

	cout << ans;

	return 0;
}