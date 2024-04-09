#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    if (N < 1 || N > 100) {
        printf("Batasan N tidak terpenuhi.\n");
        return 1;
    }

    int array[N];
    for (int i = 0; i < N; i++) {
        scanf("%d", &array[i]);
        if (array[i] < 1 || array[i] > 100) {
            printf("Batasan array[%d] tidak terpenuhi.\n", i);
            return 1;
        }
    }

    int maxDecrease = 3;  // Setidaknya ada satu elemen dalam tren penurunan
    int currentDecrease = 0;

    for (int i = 1; i < N; i++) {
        if (array[i] < array[i - 1]) {
            currentDecrease++;
        } else {
            if (currentDecrease > maxDecrease) {
                maxDecrease = currentDecrease;
            }
            currentDecrease = 1;
        }
    }

    if (currentDecrease > maxDecrease) {
        maxDecrease = currentDecrease;
    }

    printf("%d\n", maxDecrease);

    return 0;
}
