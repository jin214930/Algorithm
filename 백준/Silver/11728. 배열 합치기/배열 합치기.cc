#include <bits/stdc++.h>
using namespace std;

int n, m, a[1000000], b[1000000];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	for (int i = 0; i < m; i++)
		cin >> b[i];
	
	sort(a, a + n);
	sort(b, b + m);

	int i = 0, j = 0;
	while (i < n && j < m) {
		if (a[i] > b[j]) {
			cout << b[j] << ' ';
			j++;
		}
		else {
			cout << a[i] << ' ';
			i++;
		}
	}

	for (i; i < n; i++)
		cout << a[i] << ' ';
	for (j; j < m; j++)
		cout << b[j] << ' ';


	return 0;
}