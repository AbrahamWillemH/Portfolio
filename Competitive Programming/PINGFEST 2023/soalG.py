N = int(input())
array = []

if 1 <= N <= 100:
    for i in range(N):
        element = int(input)
        if 1 <= element <= 100:
            array.append(element)
        else:
            print("Elemen array harus dalam rentang 1 hingga 100.")
            exit(1)
else:
    print("Jumlah elemen array harus dalam rentang 1 hingga 100.")
    exit(1)

current_streak = 1
max_streak = 1

for i in range(1, N):
    if array[i] < array[i - 1]:
        current_streak += 1
    else:
        current_streak = 1
    
    if current_streak > max_streak:
        max_streak = current_streak

print(max_streak)
