#include <bits/stdc++.h>
using namespace std;

int n, m, s, v[50], visited[51][1001], ans = -1;



int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> s >> m;
	for (int i = 0; i < n; i++) 
		cin >> v[i];
	
	visited[0][s] = 1;
	

	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= m; j++) {
			if (visited[i][j] && j + v[i] <= m)
				visited[i + 1][j + v[i]] = 1;
			if (visited[i][j] && j - v[i] >= 0)
				visited[i + 1][j - v[i]] = 1;
		}
	}

	for (int i = 0; i <= m; i++) {
		if (visited[n][i])
			ans = max(ans, i);
	}

	cout << ans;



	return 0;
}