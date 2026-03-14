#include <bits/stdc++.h>
using namespace std;

long long a, b, v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b >> v;
	long long ans = (v - a) / (a - b);
	if ((v - a) % (a - b) == 0)
		ans++;
	else
		ans += 2;
	cout << ans;


	return 0;
}