import math

def calculate_mod(n, mod=10 ** 9 + 7):
    result = 0
    for k in range(n):
        sign = (-1) ** k

        binomial1 = math.comb(n - 1, k)

        exponent = math.comb(n - 1 - k, 2)
        power = pow(2, exponent, mod)

        term = sign * binomial1 * power
        result = (result + term) % mod

    result = (result * n) % mod
    return result


n = int(input())
print(calculate_mod(n))
