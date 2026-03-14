#include <bits/stdc++.h>
using namespace std;

int h, w, n, m;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> h >> w >> n >> m;
	int tmp1 = h / (n + 1);
	int tmp2 = w / (m + 1);
	if (h % (n + 1))
		tmp1++;
	if (w % (m + 1))
		tmp2++;

	cout << tmp1 * tmp2;



	return 0;
}