#include <bits/stdc++.h>
using namespace std;

int n, m, psum[1025][1025];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			int tmp;
			cin >> tmp;
			psum[i][j] = psum[i - 1][j] + tmp;
		}
	}

	while (m--) {
		int sum = 0;
		int a, b, c, d;
		cin >> a >> b >> c >> d;

		for (int i = b; i <= d; i++) 
			sum += psum[c][i] - psum[a - 1][i];

		cout << sum << '\n';
	}
	
	
	return 0;
}