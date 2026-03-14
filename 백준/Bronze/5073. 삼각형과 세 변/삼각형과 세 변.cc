#include <bits/stdc++.h>
using namespace std;

int a[3];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (true) {
		for (int i = 0; i < 3; i++)
			cin >> a[i];
		if (a[0] == 0 && a[1] == 0 && a[2] == 0)
			break;
		sort(a, a + 3);
		if (a[2] >= a[1] + a[0])
			cout << "Invalid\n";
		else if (a[0] == a[1] && a[1] == a[2])
			cout << "Equilateral\n";
		else if (a[0] == a[1] || a[1] == a[2] || a[0] == a[2])
			cout << "Isosceles\n";
		else
			cout << "Scalene\n";
		
	}

	return 0;
}