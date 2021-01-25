test = int(input())

while(test > 0):
    test = test-1
    n = int(input())
    x = n/2020
    y = n % 2020

    if(x >= y):
        print("YES")
    else:
        print("NO")
