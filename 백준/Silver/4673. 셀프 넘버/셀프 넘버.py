natural_num = set(range(1,10001))
generated_num = set()

for num in sorted(natural_num):
    
    n = num
    
    while n <= 10000:
        for i in str(n):
            n += int(i)
        generated_num.add(n)

for num in sorted(natural_num-generated_num):
    print(num)