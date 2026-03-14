#include <bits/stdc++.h>
using namespace std;

long long n, d[46];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	d[0] = 0;
	d[1] = 1;
	for (int i = 2; i <= n; i++)
		d[i] = d[i - 1] + d[i - 2];

	cout << d[n];

	return 0;
}