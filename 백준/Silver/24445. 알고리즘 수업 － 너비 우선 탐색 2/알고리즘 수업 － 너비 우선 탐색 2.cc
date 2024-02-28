#include <bits/stdc++.h>
#include <vector>
#include <queue>

using namespace std;

vector <int> V[100001];
int visited[100001];
int N, M, R, cnt = 1;

void BFS(int R) {
    int now;
    queue <int> Q;

    visited[R] = cnt;
    Q.push(R);

    while (!Q.empty()) {
        now = Q.front();
        Q.pop();

        for (int i : V[now]) {
            if (!visited[i]) {
                Q.push(i);
                visited[i] = ++cnt;
            }
        }
    }

}

int main() {
    int a, b;

    scanf("%d %d %d", &N, &M, &R);
    for (int i = 0; i < M; i++) {
        scanf("%d %d", &a, &b);
        V[a].push_back(b);
        V[b].push_back(a);
    }

    for (int i = 1; i <= N; i++) {
        if (V[i].size() > 1)
            sort(V[i].rbegin(), V[i].rend());
    }

    BFS(R);

    for (int i = 1; i <= N; i++) printf("%d\n", visited[i]);

    return 0;
}