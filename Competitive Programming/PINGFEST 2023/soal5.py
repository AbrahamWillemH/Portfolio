# Fungsi untuk menghitung FPB (Faktor Persekutuan Besar)
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

P, Q = map(int, input().split())
R, S = map(int, input().split())

if 1 <= P < 1000 and 1 <= Q < 1000 and 1 <= R < 1000 and 1 <= S < 1000:
    numerator = P * S - R * Q
    denominator = Q * S

    common_divisor = gcd(numerator, denominator)

    numerator_simplified = numerator // common_divisor
    denominator_simplified = denominator // common_divisor

    print(numerator_simplified, denominator_simplified)
else:
    print("Nilai P, Q, R, atau S diluar batasan.")
