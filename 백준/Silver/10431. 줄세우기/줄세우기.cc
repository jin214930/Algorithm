#include <bits/stdc++.h>
using namespace std;

int p, t, a[20], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> p;
	while (p--) {
		ans = 0;
		cin >> t;
		for (int i = 0; i < 20; i++) 
			cin >> a[i];
		
		for (int i = 1; i < 20; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[i])
					ans++;
			}
		}

		cout << t << ' ' << ans << '\n';
	}
	

	return 0;
}