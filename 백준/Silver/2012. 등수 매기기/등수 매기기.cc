#include <bits/stdc++.h>
#include <vector>

using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int>v(N);
    bool arr[N + 1] = {false};

    for (int i = 0; i < N; i++) {
        cin >> v[i];
    }

    sort(v.begin(), v.end());

    long long result = 0;
    for(int i = 0; i < N; i++) {
        result += abs((i + 1) - v[i]);
    }

    cout << result << '\n';
    return 0;
}