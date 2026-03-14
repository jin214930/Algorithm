#include <bits/stdc++.h>
using namespace std;

int n, d[1000001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	d[0] = 0;
	d[1] = 1;

	for (int i = 2; i <= 1000000; i++) 
		d[i] = (d[i - 1] + d[i - 2]) % 1000000000;
	
	if (n > 0 || abs(n) % 2)
		cout << 1;
	else if (n == 0)
		cout << 0;
	else
		cout << -1;

	cout << '\n' << d[abs(n)];

	return 0;
}