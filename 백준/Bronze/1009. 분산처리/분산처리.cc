#include <bits/stdc++.h>
using namespace std;

int t, a, b;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		cin >> a >> b;
		int ans = a % 10;
		for (int i = 0; i < b - 1; i++) 
			ans = ans * a % 10;
		if (ans)
			cout << ans << '\n';
		else
			cout << 10 << '\n';
	}


	return 0;
}