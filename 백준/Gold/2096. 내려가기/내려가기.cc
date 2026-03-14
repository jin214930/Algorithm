#include <bits/stdc++.h>
using namespace std;

int n, d[3][2];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int a, b, c;
		int a1, a2, b1, b2, c1, c2;
		cin >> a >> b >> c;
		a1 = d[0][0];
		a2 = d[0][1];
		b1 = d[1][0];
		b2 = d[1][1];
		c1 = d[2][0];
		c2 = d[2][1];
		
		d[0][0] = min(a1, b1) + a;
		d[0][1] = max(a2, b2) + a;
		d[1][0] = min({ a1, b1, c1 }) + b;
		d[1][1] = max({ a2, b2, c2 }) + b;
		d[2][0] = min(b1, c1) + c;
		d[2][1] = max(b2, c2) + c;
	}

	cout << max({ d[0][1], d[1][1], d[2][1] });
	cout << ' ';
	cout << min({ d[0][0], d[1][0], d[2][0] });

	return 0;
}