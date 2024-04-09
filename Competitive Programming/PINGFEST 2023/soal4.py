def min_rotations_to_unlock(initial, target):
    n = len(initial)
    rotations = 0

    for i in range(n):
        diff = abs(int(target[i]) - int(initial[i]))
        rotations += min(diff, 10 - diff)

    return rotations

initial = input()
target = input()

print(min_rotations_to_unlock(initial, target))
