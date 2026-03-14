#include <bits/stdc++.h>
using namespace std;

string a, b;

string go(string a, string b) {
	string ret = "";
	int c = 0;

	reverse(a.begin(), a.end());
	reverse(b.begin(), b.end());

	for (int i = 0; i < a.size(); i++) {
		int tmp = a[i] + b[i] - '0' * 2 + c;
		c = tmp / 10;
		ret += tmp % 10 + '0';
	}

	for (int i = 0; i < b.size() - a.size(); i++) {
		int tmp = b[i + a.size()] - '0' + c;
		c = tmp / 10;
		ret += tmp % 10 + '0';
	}

	if (c)
		ret += c + '0';

	reverse(ret.begin(), ret.end());
	return ret;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b;

	if (a.size() > b.size())
		cout << go(b, a);
	else
		cout << go(a, b);

	return 0;
}