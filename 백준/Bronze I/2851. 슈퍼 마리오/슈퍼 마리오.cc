#include <bits/stdc++.h>

using namespace std;
int arr[10];
int total = 0;
int answer = 0;

int main(){
    for(int i=0; i<10; i++) {
        cin >> arr[i];
    }

    for(int i=0; i<10; i++) {
        total += arr[i];
        if(abs(100 - total) <= abs(100 - answer)) {
            answer = total;
        }
    }
    cout << answer;
}