test = int(input())

while(test > 0):
    test = test-1
    n = int(input())

    if((n & (n-1)) == 0):
        print("NO")
    else:
        print("YES")
