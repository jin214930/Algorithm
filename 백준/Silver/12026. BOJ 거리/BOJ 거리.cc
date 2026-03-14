#include <bits/stdc++.h>
using namespace std;

int n, d[1000];
string s;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> s;
	for (int i = 1; i < n; i++) {
		d[i] = 999999999;
		if (s[i] == 'B') {
			for (int j = 0; j < i; j++) {
				if (s[j] == 'J')
					d[i] = min(d[i], d[j] + (i - j) * (i - j));
			}
		} 
		else if (s[i] == 'O') {
			for (int j = 0; j < i; j++) {
				if (s[j] == 'B')
					d[i] = min(d[i], d[j] + (i - j) * (i - j));
			}
		}
		else {
			for (int j = 0; j < i; j++) {
				if (s[j] == 'O')
					d[i] = min(d[i], d[j] + (i - j) * (i - j));
			}
		}
	}

	if (d[n - 1] == 999999999)
		cout << -1;
	else
		cout << d[n - 1];


	return 0;
}