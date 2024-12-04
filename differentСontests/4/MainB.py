import sys
from typing import List


def calc_difference(P: List[List[int]], sizes: List[int], Ti: List[int]) -> int:
    total_diff = 0
    for i in range(len(P)):
        for j in range(sizes[i]):
            total_diff += abs(P[i][j] - Ti[i])
    return total_diff


def main():
    n = int(input())
    P = []
    sizes = []
    for _ in range(n):
        sizes_input = input().strip().split()
        sizes.append(int(sizes_input[0]))
        P.append(list(map(int, sizes_input[1:])))

    T = int(input())

    Ti = [T // n] * n 
    remainder = T % n


    for i in range(remainder):
        Ti[i] += 1


    current_diff = calc_difference(P, sizes, Ti)


    improved = True
    while improved:
        improved = False
        for i in range(n):
            for j in range(n):
                if i != j and Ti[i] > 0:
                
                    Ti[i] -= 1
                    Ti[j] += 1

                    new_diff = calc_difference(P, sizes, Ti)

                
                    if new_diff < current_diff:
                        current_diff = new_diff
                        improved = True
                    else:
                    
                        Ti[i] += 1
                        Ti[j] -= 1


    print(" ".join(map(str, Ti)))


if __name__ == "__main__":
    main()
