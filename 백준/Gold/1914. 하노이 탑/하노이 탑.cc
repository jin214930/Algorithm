#include <bits/stdc++.h>
using namespace std;

int n;
string d[101];

string go(string a, string b) {
	string ret = "";
	if (a.size() < b.size())
		swap(a, b);
	reverse(a.begin(), a.end());
	reverse(b.begin(), b.end());

	int c = 0;
	for (int i = 0; i < a.size(); i++) {
		if (i < b.size()) {
			int tmp = a[i] + b[i] - '0' * 2 + c;
			c = tmp / 10;
			ret.push_back(tmp % 10 + '0');
		}
		else {
			int tmp = a[i] - '0' + c;
			c = tmp / 10;
			ret.push_back(tmp % 10 + '0');
		}
	}
	if (c)
		ret.push_back(c + '0');

	reverse(ret.begin(), ret.end());
	return ret;
}

void go(int n, int from, int by, int to) {
	if (n == 1) {
		cout << from << ' ' << to << '\n';
		return;
	}

	go(n - 1, from, to, by);
	cout << from << ' ' << to << '\n';
	go(n - 1, by, from, to);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	d[1] = "1";
	for (int i = 2; i <= n; i++) {
		d[i] = go(go(d[i - 1], d[i - 1]), "1");
	}

	cout << d[n] << '\n';

	if(n <= 20)
		go(n, 1, 2, 3);
	
	return 0;
}