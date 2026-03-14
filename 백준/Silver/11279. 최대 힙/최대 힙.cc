#include <bits/stdc++.h>
using namespace std;

int n, x;
priority_queue<int> pq;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> x;
		if (x)
			pq.push(x);
		else {
			if (pq.size()) {
				cout << pq.top() << '\n';
				pq.pop();
			}
			else
				cout << 0 << '\n';
		}
	}

	return 0;
}