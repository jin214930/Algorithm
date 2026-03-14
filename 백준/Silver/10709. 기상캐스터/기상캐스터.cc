#include <bits/stdc++.h>
using namespace std;

int h, w, visited[100][100];
char a[100][100];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> h >> w;

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			cin >> a[i][j];
			if(a[i][j] == '.')
				visited[i][j] = -1;
		}
	}

	for (int i = 0; i < h; i++) {
		for (int j = 1; j < w; j++) {
			if (visited[i][j - 1] != -1 && visited[i][j] == -1)
				visited[i][j] = visited[i][j - 1] + 1;
		}
	}

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++)
			cout << visited[i][j] << ' ';
		cout << '\n';
	}
	

	

	return 0;
}