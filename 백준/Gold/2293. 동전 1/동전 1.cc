#include <bits/stdc++.h>
using namespace std;

int n, k, a[100], d[10001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	
	d[0] = 1;
	for (int i = 0; i < n; i++) {
		for (int j = a[i]; j <= k; j++)
			d[j] += d[j - a[i]];
	}

	cout << d[k];


	return 0;
}