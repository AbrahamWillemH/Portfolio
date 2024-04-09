#include <stdio.h>
#include <string.h>

int minRotationsToOpenLock(char* initial, char* target, int n) {
    int rotations = 0;

    for (int i = 0; i < n; i++) {
        int diff = (target[i] - '0') - (initial[i] - '0');
        if (diff < 0) diff += 10;  // Handle rotasi melalui 0
        rotations += diff;
    }

    return rotations;
}

int main() {
    char initial[1000000];
    char target[1000000];

    scanf("%s", initial);
    scanf("%s", target);

    int n = strlen(initial);
    int result = minRotationsToOpenLock(initial, target, n);
    printf("%d\n", result);

    return 0;
}
