#include <bits/stdc++.h>
using namespace std;

long long t, n, d[1000001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 1; i <= 1000000; i++) {
		for (int j = i; j <= 1000000; j += i) {
			d[j] += i;
		}
		d[i] += d[i - 1];
	}

	
	cin >> t;
	while (t--) {
		cin >> n;
		cout << d[n] << '\n';
	}

	return 0;
}