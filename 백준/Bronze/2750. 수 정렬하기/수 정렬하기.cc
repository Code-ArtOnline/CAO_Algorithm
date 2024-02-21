#include <bits/stdc++.h>

using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> A(N, 0);

    for(int i = 0; i < N; i++) {
        cin >> A[i];
    }

    for(int i = 0; i < N - 1; i++) {
        for(int j = 0; j < N - 1; j++) {
            if(A[j] > A[j+1]) {
                int temp = A[j];
                A[j] = A[j+1];
                A[j+1] = temp;
            }
        }
    }

    for(int i = 0; i < N; i++) {
        cout << A[i] << "\n";
    }
}