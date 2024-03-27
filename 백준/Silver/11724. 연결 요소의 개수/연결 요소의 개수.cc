#include<iostream>
#include<vector>
using namespace std;

vector<int> vertex[1001];
bool visited[1001];
int N, M;

void DFS(int index)
{
	visited[index] = true;
	for (int i = 0; i < vertex[index].size(); i++)
	{
		if (visited[vertex[index][i]]) 
            continue;
		DFS(vertex[index][i]);
	}
}
int main()
{
	cin >> N >> M;
	int u, v;
	int answer = 0;
	for (int i = 0; i < M; i++)
	{
		cin >> u >> v;
		vertex[u].push_back(v);
		vertex[v].push_back(u);
	}
	for (int i = 1; i <= N; i++)
	{
		if (visited[i]) 
            continue;
		DFS(i);
		answer++;
	}
	cout << answer;
	return 0;
}
