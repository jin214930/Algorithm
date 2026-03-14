#include <bits/stdc++.h>
using namespace std;

int n, x;
priority_queue<int, vector<int>, greater<int>> pq1;
priority_queue<int> pq2;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	while (n--) {
		cin >> x;
		if (x > 0)
			pq1.push(x);
		else if (x < 0)
			pq2.push(x);
		else {
			if (pq1.empty() && pq2.empty())
				cout << 0;
			else if (pq1.empty() && pq2.size()) {
				cout << pq2.top();
				pq2.pop();
			}
			else if (pq1.size() && pq2.empty()) {
				cout << pq1.top();
				pq1.pop();
			}
			else {
				if (abs(pq1.top()) >= abs(pq2.top())) {
					cout << pq2.top();
					pq2.pop();
				}
				else {
					cout << pq1.top();
					pq1.pop();
				}
			}
			cout << '\n';
		}
	}



	return 0;
}