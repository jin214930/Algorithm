#include <bits/stdc++.h>
using namespace std;

string a, b;
double n, cnt, sum;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 0; i < 20; i++) {
		cin >> a >> n >> b;
		if (b == "P")
			continue;
		cnt += n;
		if (b == "A+")
			sum += n * 4.5;
		else if (b == "A0")
			sum += n * 4.0;
		else if (b == "B+")
			sum += n * 3.5;
		else if (b == "B0")
			sum += n * 3.0;
		else if (b == "C+")
			sum += n * 2.5;
		else if (b == "C0")
			sum += n * 2.0;
		else if (b == "D+")
			sum += n * 1.5;
		else if (b == "D0")
			sum += n * 1.0;
	}

	cout << sum / cnt;


	return 0;
}