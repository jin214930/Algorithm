#include <bits/stdc++.h>
using namespace std;

int n;


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (cin >> n) {
		int tmp = 1;
		int ans = 1;

		while (true) {
			if (tmp % n == 0) {
				cout << ans << '\n';
				break;
			}
			tmp = (tmp * 10 + 1) % n;
			ans++;
		}
	}
	
	return 0;
}