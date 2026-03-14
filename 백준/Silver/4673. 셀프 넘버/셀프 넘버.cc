#include <bits/stdc++.h>
using namespace std;

int a[10001], ans;

int go(int n) {
	int sum = n;
	while (n) {
		sum += n % 10;
		n /= 10;
	}

	return sum;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 1; i <= 10000; i++) {
		if (!a[i]) {
			int tmp = i;
			while (true) {
				tmp = go(tmp);
				if (tmp > 10000)
					break;
				a[tmp] = 1;
			}
		}
	}

	for (int i = 1; i <= 10000; i++) {
		if (!a[i])
			cout << i << '\n';
	}
	

	return 0;
}