#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int findMinimumRotations(string initial, string target) {
    int n = initial.length();
    int minRotations = INT_MAX;

    for (int i = 0; i < n; i++) {
        int rotations = 0;
        for (int j = 0; j < n; j++) {
            int initialDigit = initial[(i + j) % n] - '0';
            int targetDigit = target[j] - '0';
            rotations += min(abs(initialDigit - targetDigit), 10 - abs(initialDigit - targetDigit));
        }
        minRotations = min(minRotations, rotations);
    }

    return minRotations;
}

int main() {
    string initialCombination, targetCombination;
    cin >> initialCombination >> targetCombination;

    int minRotations = findMinimumRotations(initialCombination, targetCombination);

    cout << minRotations << endl;

    return 0;
}
