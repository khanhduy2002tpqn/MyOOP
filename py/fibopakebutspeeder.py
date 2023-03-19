# Bài này dùng giải thuật nhân ma trận để tính số Fibonacci 
# vì khi chúng ta tính số fibonacci thứ n thì bai toán sẽ là:
# F(n)=[1,1]^(n-1) và ta có tính chất toán học là A^n = A^x.A^y (với x+y=n) 
#      [1,0]
# => ta có thể đưa F(n)= [1,1]^x . [1,1]^y 
#                        [1,0]     [1,0]
# ta thấy ta có thể tính độc lập các mũ nhỏ hơn nên chúng ta có thể chia nhỏ 
# số mũ để tính song song và gộp lại sẽ có số fibonacci mà ta cần tìm



import time
from multiprocessing import Process, cpu_count, Manager
import math

def Mul(F, M):# Hàm nhân 2 ma trận
    a, b = F[0]
    c, d = F[1]
    x, y = M[0] 
    z, w = M[1]
    return [
        [a*x + b*z, a*y + b*w,],
        [c*x + d*z, c*y + d*w,]
    ]


def Fibonacci(n, check_matrix=False):# Hàm tính fibonacci
    q = [
        [1, 1],
        [1, 0]
    ]

    if n < 0: return -1
    if n < 2:
        if check_matrix: return q
        return n
    elif n == 2:
        if check_matrix: return q
        return 1

    m = []

    alpha = (n-1) // 2

    while alpha >= 1:
        n = int(math.log2(alpha))#Tính số lần lặp của ma trận 
        r = q
        for i in range(n):
            r = Mul(r, r) 
        m.append(r)
        alpha -= 2**n
        

    for i in range(1, len(m)):
        m[0] = Mul(m[0], m[i])
    
    m = Mul(m[0], m[0])
    
    if (n-1) % 2 != 0:
        m = Mul(m, q)

    if check_matrix: return m
    return m[0][0]


def calculate_fibonacci(n, id, list_maxtrix):# trung gian các kết quả tính toán sẽ lưu vào mảng list_maxtrix 
    list_maxtrix[id] = Fibonacci(n, True)
  


def parallel_fibonacci(n, num_process=cpu_count()):
    if n < 0:
        return -1
    if n < 2:
        return n
    elif n == 2:
        return 1
    
    # if n < 256: # Nếu nó nhỏ hơn
    #     return Fibonacci(n)

    _mod = Fibonacci(1, True)
    list_maxtrix = Manager().list([_mod for i in range(num_process)])# tạo giá trị ban đầu cho mảng bằng [1,1],[1,0]
    list_process = []
    step = n // num_process # tính số mũ mỗi lần tính
    
    for i in range(num_process): # tạo list song song
        list_process.append(Process(
            target=calculate_fibonacci,
            args=(step, i, list_maxtrix)
        ))
    for i in range(num_process): #chạy song song
        list_process[i].start()
    for i in range(num_process):
        list_process[i].join()

    for i in range(1, num_process):#trả lại giá trị ở vị trí 0
        list_maxtrix[i] = Mul(list_maxtrix[i], _mod)
        list_maxtrix[0] = Mul(list_maxtrix[0], list_maxtrix[i])

    mod_step = n % num_process # tính những số dư còn lại và add vào list
    
    if mod_step > 1:
       list_maxtrix[0] = Mul(list_maxtrix[0], Fibonacci(mod_step))
    
    
    if mod_step != 0:
         list_maxtrix[0] = Mul(list_maxtrix[0], _mod)
    
    return list_maxtrix[0][0][0]  # type: ignore

    
if __name__ == "__main__":

    start = time.time()
    fibonacci = Fibonacci(1000)
    end = time.time()
    
    print("Fibonacci is 1000th =", fibonacci)
    print("Compute in times:", end-start, "seconds")
    start = time.time()
    fibonacci = parallel_fibonacci(1000, 4)
    end = time.time()
    
    print("Parallel fibonacci 1000th =", fibonacci)
    print("Compute in times:", end-start, "seconds")
    
    
    
    
    