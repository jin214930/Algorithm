#include <bits/stdc++.h>
using namespace std;

int n, k, ans;
vector<pair<int, int>> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back({ i, tmp });
	}

	do {
		ans++;
		int tmp = 500;
		for (int i = 0; i < n; i++) {
			tmp -= k;
			tmp += v[i].second;
			if (tmp < 500) {
				ans--;
				break;
			}
		}
	} while (next_permutation(v.begin(), v.end()));

	cout << ans;

	return 0;
}