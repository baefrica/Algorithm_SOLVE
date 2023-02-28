def solution(n):
    answer = 0
    list = []
    for i in str(n):
        list.append(int(i))
    
    list.sort()
    list.reverse()
    
    tmp = ""
    for i in list:
        tmp += str(i)
        
    answer = int(tmp)
    return answer