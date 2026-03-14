#include <bits/stdc++.h>
using namespace std;

int n, a[11], mn = 9999999990, mx = -9999999999;
vector<int> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];

	for (int i = 0; i < 4; i++) {
		int tmp;
		cin >> tmp;
		for (int j = 0; j < tmp; j++)
			v.push_back(i);
	}

	do {
		int tmp = a[0];
		for (int i = 0; i < v.size(); i++) {
			if (v[i] == 0)
				tmp += a[i + 1];
			else if (v[i] == 1)
				tmp -= a[i + 1];
			else if (v[i] == 2)
				tmp *= a[i + 1];
			else 
				tmp /= a[i + 1];
		}
		mn = min(mn, tmp);
		mx = max(mx, tmp);
	} while (next_permutation(v.begin(), v.end()));

	cout << mx << '\n' << mn;

	return 0;
}