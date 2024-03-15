#include <bits/stdc++.h>

using namespace std;

int main() {
    int N = 0;
    cin >> N;

    int* times = new int[N];
    for(int i = 0; i < N; i++) {
        cin >> times[i];
    }

    sort(times, times + N);

    int result = 0;
    for(int j = 0; j < N; j++) {
        result += (N-j) * times[j];
    }
    cout << result;
    return 0;
}