#include <bits/stdc++.h>
using namespace std;

int n, a[1001], d[1001], pre[1001], ans;
vector<int> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> a[i];
	d[1] = 1;
	for (int i = 2; i <= n; i++) {
		d[i] = 1;
		for (int j = 1; j < i; j++) {
			if (a[i] > a[j] && d[i] < d[j] + 1) {
				d[i] = d[j] + 1;
				pre[i] = j;
			}
		}
	}

	int idx;
	for (int i = 1; i <= n; i++) {
		if (d[i] > ans) {
			idx = i;
			ans = d[i];
		}
	}

	cout << ans << '\n';

	for (int i = idx; i != 0; i = pre[i])
		v.push_back(a[i]);
	reverse(v.begin(), v.end());
	for (int i : v)
		cout << i << ' ';


	return 0;
}