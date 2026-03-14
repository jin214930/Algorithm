#include <bits/stdc++.h>
using namespace std;

int n, d[100001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	d[1] = 1;
	for (int i = 2; i <= n; i++) {
		d[i] = d[i - 1] + 1;
		for (int j = 2; j * j <= i; j++) 
			d[i] = min(d[i], d[i - j * j] + 1);
	}

	cout << d[n];
	
	

	return 0;
}