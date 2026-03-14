#include <bits/stdc++.h>
using namespace std;

int n, m, ans;
char a[50][50], b[50][50];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) 
			cin >> a[i][j];
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cin >> b[i][j];
	}

	for (int i = 0; i < n - 2; i++) {
		for (int j = 0; j < m - 2; j++) {
			if (a[i][j] != b[i][j]) {
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						if (a[k][l] == '0')
							a[k][l] = '1';
						else
							a[k][l] = '0';
					}
				}
				ans++;
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] != b[i][j]) {
				cout << -1;
				return 0;
			}
		}
	}

	cout << ans;

	return 0;
}