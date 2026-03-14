#include <bits/stdc++.h>
using namespace std;

string s;
int cnt0, cnt1;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s;
	for (char c : s) {
		if (c == '0')
			cnt0++;
		else
			cnt1++;
	}
	cnt1 /= 2;
	cnt0 /= 2;

	for (char c : s) {
		if (c == '1') {

			if (cnt1)
				cnt1--;
			else
				cout << c;
		}
		else {
			if (cnt0) {
				cout << c;
				cnt0--;
			}
		}
	}
	
	return 0;
}