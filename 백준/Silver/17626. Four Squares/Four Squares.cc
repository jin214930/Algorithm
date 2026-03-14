#include <bits/stdc++.h>
using namespace std;

int n, d[50001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;

	d[1] = 1;
	d[2] = 2;
	for (int i = 3; i <= n; i++) {
		int tmp = 999999999;
		for (int j = 1; j * j <= i; j++)
			tmp = min(d[i - j * j], tmp);
		d[i] = tmp + 1;
	}

	cout << d[n] << '\n';
	

	return 0;
}