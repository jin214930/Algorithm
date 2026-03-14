#include <bits/stdc++.h>
using namespace std;

int n;
char adj[26][2];

void pre(int x) {
	cout << char(x + 'A');
	if (adj[x][0] != '.')
		pre(adj[x][0] - 'A');
	if (adj[x][1] != '.')
		pre(adj[x][1] - 'A');
}
void in(int x) {
	if (adj[x][0] != '.')
		in(adj[x][0] - 'A');
	cout << char(x + 'A');
	if (adj[x][1] != '.')
		in(adj[x][1] - 'A');
}
void post(int x) {
	if (adj[x][0] != '.')
		post(adj[x][0] - 'A');
	if (adj[x][1] != '.')
		post(adj[x][1] - 'A');
	cout << char(x + 'A');
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		char a, b, c;
		cin >> a >> b >> c;
		adj[a - 'A'][0] = b;
		adj[a - 'A'][1] = c;
	}

	pre(0);
	cout << '\n';
	in(0);
	cout << '\n';
	post(0);


	return 0;
}