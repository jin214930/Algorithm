#include <bits/stdc++.h>
using namespace std;

string n;
int sum;
bool flag;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	for (char c : n) {
		sum += c - '0';
		if (c == '0')
			flag = true;
	}

	if (!flag || sum % 3) {
		cout << -1;
		return 0;
	}

	sort(n.rbegin(), n.rend());
	cout << n;



	return 0;
}