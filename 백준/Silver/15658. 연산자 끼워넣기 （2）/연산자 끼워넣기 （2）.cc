#include <bits/stdc++.h>
using namespace std;

int n, a[11], b[4], mn = 1000000000, mx = -1000000000;

void go(int k, int ret) {
	if (k == n) {
		mx = max(mx, ret);
		mn = min(mn, ret);
		return;
	}

	for (int i = 0; i < 4; i++) {
		if (b[i]) {
			int tmp = ret;
			if (i == 0)
				tmp += a[k];
			else if (i == 1)
				tmp -= a[k];
			else if (i == 2)
				tmp *= a[k];
			else
				tmp /= a[k];
			b[i]--;
			go(k + 1, tmp);
			b[i]++;
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	for (int i = 0; i < 4; i++)
		cin >> b[i];

	go(1, a[0]);

	cout << mx << '\n' << mn;

	return 0;
}