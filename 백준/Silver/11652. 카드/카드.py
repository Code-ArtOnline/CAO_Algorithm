import sys
input = sys.stdin.readline

dic = {}

for _ in range(int(input())):
    n = int(input())
    if n not in dic:
        dic[n]=1
    else:
        dic[n] += 1

sorted_dict = sorted(dic.items(),key = lambda x : (-x[1],x[0]))
print(sorted_dict[0][0])