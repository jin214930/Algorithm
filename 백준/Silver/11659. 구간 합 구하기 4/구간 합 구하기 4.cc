#include <bits/stdc++.h>
using namespace std;

int n, m, x, y, tmp, psum[100001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		cin >> tmp;
		psum[i] = psum[i - 1] + tmp;
	}

	for (int i = 0; i < m; i++) {
		cin >> x >> y;
		cout << psum[y] - psum[x - 1] << '\n';
	}
	

	return 0;
}