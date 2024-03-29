#include<iostream>
#include<vector>
using namespace std;

vector<pair<int, long>> v[5010];

long long DFS(int node,int p)
{
	long long distance = 0;
	for (int i = 0; i < v[node].size(); i++) {
		if (v[node][i].first == p)
            continue;
		distance = max(distance, DFS(v[node][i].first, node) + v[node][i].second);
	}
	return distance;
}

int main()
{

	int N;
	int a, b, c;
	cin >> N;

	for (int i = 0; i < N - 1; i++) {
		cin >> a >> b >> c;
		v[a].push_back({ b,c });
		v[b].push_back({ a,c });
	}
	cout<< DFS(1,-1);
	return 0;
}
