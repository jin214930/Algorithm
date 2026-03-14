#include <bits/stdc++.h>
using namespace std;

string a, b;
int ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	getline(cin, a);
	getline(cin, b);

	int i = 0;
	while (i < a.size()) {
		if (a[i] == b[0]) {
			if (a.substr(i, b.size()) == b) {
				ans++;
				i += b.size();
			}
			else
				i++;
		}
		else
			i++;
	}

	cout << ans;
	
	return 0;
}