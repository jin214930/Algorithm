#include <bits/stdc++.h>
using namespace std;

int n, cnt;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	
	int tmp = 666;
	while (true) {
		if (to_string(tmp).find("666") != string::npos)
			cnt++;
		if (cnt == n)
			break;
		tmp++;
	}

	cout << tmp;

	return 0;
}