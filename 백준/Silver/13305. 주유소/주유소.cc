#include <bits/stdc++.h>
using namespace std;

int n;
long long a[100000], d[100000], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n - 1; i++)
		cin >> d[i];
	for (int i = 0; i < n; i++)
		cin >> a[i];

	long long mn = a[0];

	for (int i = 0; i < n - 1; i++) {
		ans += d[i] * mn;
		mn = min(mn, a[i + 1]);
	}
	cout << ans;	

	return 0;
}