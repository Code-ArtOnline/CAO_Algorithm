#include <bits/stdc++.h>
#include <queue>

using namespace std;

int main() {
    int N;
    cin >> N;
    priority_queue<int, vector<int>, greater<int>> pq;
    int x;
    
    for(int i = 0; i < N; i++) {
        cin >> x;
        pq.push(x);
    }
    
    int x1 = 0;
    int x2 = 0;
    int sum = 0;
    
    while(pq.size() != 1) {
        x1 = pq.top();
        pq.pop();
        x2 = pq.top();
        pq.pop();
        
        sum += x1 + x2;
        pq.push(x1 + x2);
    }
    cout << sum << "\n";
}