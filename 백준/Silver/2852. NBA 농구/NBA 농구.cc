#include <bits/stdc++.h>
using namespace std;

int n, tn, as, bs, pt, t, at, bt;
string s;

string itos(int n) {
	string m = to_string(n / 60);
	string s = to_string(n % 60);

	if (m.size() == 1)
		m = "0" + m;
	if (s.size() == 1)
		s = "0" + s;

	return m + ":" + s;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	while (n--) {
		cin >> tn >> s;
		
		t = atoi(s.substr(0, 2).c_str()) * 60 + atoi(s.substr(s.find(":") + 1).c_str());
		
		if (as < bs)
			bt += t - pt;
		else if (as > bs)
			at += t - pt;

		if (tn == 1)
			as++;
		else
			bs++;
		pt = t;
	}

	if (as < bs)
		bt += 2880 - pt;
	else if (as > bs)
		at += 2880 - pt;

	cout << itos(at) << '\n' << itos(bt);
	

	return 0;
}