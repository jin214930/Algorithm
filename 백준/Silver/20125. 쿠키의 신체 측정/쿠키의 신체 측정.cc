#include <bits/stdc++.h>
using namespace std;

int n, y, x, b, c, d, e, f;
char a[1000][1000];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cin >> a[i][j];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (a[i][j] == '*') {
				y = i + 1;
				x = j;
				break;
			}
		}
		if (y)
			break;
	}

	for (int i = x - 1; i >= 0; i--) {
		if (a[y][i] == '*')
			b++;
		else
			break;
	}

	for (int i = x + 1; i < n; i++) {
		if (a[y][i] == '*')
			c++;
		else
			break;
	}

	for (int i = y + 1; i < n; i++) {
		if (a[i][x] == '*')
			d++;
		else
			break;
	}

	for (int i = y + 1; i < n; i++) {
		if (a[i][x - 1] == '*')
			e++;
	}

	for (int i = y + 1; i < n; i++) {
		if (a[i][x + 1] == '*')
			f++;
	}

	cout << y + 1 << ' ' << x + 1 << '\n';
	cout << b << ' ' << c << ' ' << d << ' ' << e << ' ' << f;


	
	return 0;
}