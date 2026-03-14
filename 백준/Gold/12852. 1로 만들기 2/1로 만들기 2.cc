#include <bits/stdc++.h>
using namespace std;

int n, d[1000001], pre[1000001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	d[2] = 1;
	pre[2] = 1;
	d[3] = 1;
	pre[3] = 1;
	for (int i = 4; i <= n; i++) {
		d[i] = d[i - 1] + 1;
		pre[i] = i - 1;
		if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
			d[i] = d[i / 3] + 1;
			pre[i] = i / 3;
		}
		if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
			d[i] = d[i / 2] + 1;
			pre[i] = i / 2;
		}
	}

	cout << d[n] << '\n';
	for (int i = n; i > 0; i = pre[i])
		cout << i << ' ';

	return 0;
}