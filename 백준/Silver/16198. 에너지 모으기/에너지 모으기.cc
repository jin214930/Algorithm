#include <bits/stdc++.h>
using namespace std;

int n, w[10], visited[10], ans;

void go(int k, int cnt) {
	if (k == n - 2) {
		ans = max(ans, cnt);
		return;
	}

	for (int i = 1; i < n - 1; i++) {
		if (!visited[i]) {
			visited[i] = 1;
			int tmp = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (!visited[j]) {
					tmp *= w[j];
					break;
				}
			}
			for (int j = i + 1; j < n; j++) {
				if (!visited[j]) {
					tmp *= w[j];
					break;
				}
			}
			go(k + 1, cnt + tmp);
			visited[i] = 0;
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> w[i];

	for (int i = 1; i < n - 1; i++) {
		visited[i] = 1;
		go(1, w[i - 1] * w[i + 1]);
		visited[i] = 0;
	}

	cout << ans;

	return 0;
}