#include <bits/stdc++.h>
using namespace std;

int n, a[1000000], b, c;
long long cnt;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	cin >> b >> c;
	for (int i = 0; i < n; i++) {
		a[i] -= b;
		cnt++;
		if (a[i] > 0) {
			cnt += a[i] / c;
			if (a[i] % c != 0)
				cnt++;
		}
	}

	cout << cnt;	

	return 0;
}