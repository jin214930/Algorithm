def solution(num_list):
    ans = 0
    for i in num_list:
        while i != 1:
            if i % 2 == 1:
                i -= 1
            i /= 2
            ans = ans + 1
    return ans