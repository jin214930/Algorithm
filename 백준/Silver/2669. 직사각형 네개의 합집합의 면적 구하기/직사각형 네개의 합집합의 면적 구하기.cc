#include <bits/stdc++.h>
using namespace std;

int a, b, c, d, x[101][101], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 0; i < 4; i++) {
		cin >> a >> b >> c >> d;
		for (int i = b; i < d; i++) {
			for (int j = a; j < c; j++)
				x[i][j] = 1;
		}
	}

	for (int i = 0; i < 101; i++) {
		for (int j = 0; j < 101; j++) {
			if (x[i][j])
				ans++;
		}
	}

	cout << ans;

	
	return 0;
}