#include <bits/stdc++.h>
using namespace std;

int n, a[4], b[15][5], ans1 = 999999999;
vector<vector<int>> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < 4; i++)
		cin >> a[i];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 5; j++)
			cin >> b[i][j];
	}

	for (int i = 0; i < (1 << n); i++) {
		int c[5] = { 0, 0, 0, 0, 0 };
		vector<int> tmp;
		for (int j = 0; j < n; j++) {
			if (i & (1 << j)) {
				tmp.push_back(j + 1);
				for (int k = 0; k < 5; k++)
					c[k] += b[j][k];
			}
		}

		bool flag = true;
		for (int j = 0; j < 4; j++) {
			if (c[j] < a[j]) {
				flag = false;
				break;
			}
		}

		if (flag) {
			if (ans1 > c[4]) {
				v.clear();
				ans1 = c[4];
				v.push_back(tmp);
			}
			else if (ans1 == c[4])
				v.push_back(tmp);
		}
	}

	if (ans1 != 999999999) {
		cout << ans1 << '\n';
		sort(v.begin(), v.end());
		for (int i : v[0])
			cout << i << ' ';
	}
	else
		cout << -1;

	return 0;
}