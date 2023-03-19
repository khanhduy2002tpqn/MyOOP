from multiprocessing import Pool, cpu_count
import time

F=[]
def Fibonacci(n:int) -> int :
    arrfi = []
    for i in range(0,n+1):
        if i==0 or i==1:
            arrfi.append(i)
        else:
            arrfi.append(arrfi[i-1] + arrfi[i-2])
    return arrfi[n]
def f(n:int) -> int : 
	
    if (F.count(n)): return F[n]
    k= n/2
	
    if (n%2==0): #n=2*k
        F[n] = (f(int (k))*f(int (k)) + f(int (k)-1)*f(int (k)-1)) % M
        return F[n]
    else: # n=2k+1
        F[n] = (f(int (k))*f(int (k)+1) + f(int (k)-1)*f(int (k))) % M
        return F[n]
	

def ParallelFibonacci(n):
    with Pool(16) as p:
        r = p.map(Fibonacci,[n])
        p.close()
        p.join()
    print("Fibonacci 1000th with parallel:",r[:])
if __name__ == "__main__":
    n=1000
    start = time.time()
    print("Fibonacci 1000th with non-parallel:",Fibonacci(n))
    print("Finish in",(time.time()-start),"s")

    start2 = time.time()
    ParallelFibonacci(n)
    print("Finish in",(time.time()-start2),"s")