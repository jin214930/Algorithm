#include <bits/stdc++.h>
using namespace std;

int n, l, x, y, ans;
vector<pair<int, int>> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> l;
	while (n--) {
		cin >> x >> y;
		v.push_back({ x, y });
	}

	sort(v.begin(), v.end());

	int start = 0;
	for (auto i : v) {
		if (start < i.first)
			start = i.first;
		if (start > i.second)
			continue;
		if ((i.second - start) % l) {
			int tmp = (i.second - start) / l + 1;
			ans += tmp;
			start = start + tmp * l;
		}
		else {
			int tmp = (i.second - start) / l;
			ans += tmp;
			start = start + tmp * l;
		}
	}

	cout << ans;

	return 0;
}