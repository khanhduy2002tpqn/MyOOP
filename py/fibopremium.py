import time
from multiprocessing import Process, cpu_count, Manager
import math
import logging


def Multiply(F, M):
    return [
        [(F[0][0] * M[0][0] + F[0][1] * M[1][0]), (F[0][0] * M[0][1] + F[0][1] * M[1][1])],
        [(F[1][0] * M[0][0] + F[1][1] * M[1][0]), (F[1][0] * M[0][1] + F[1][1] * M[1][1])]
    ]


def Fibonacci(value, return_state_matrix=False):
    q = [
        [1, 1],
        [1, 0]
    ]

    if value < 0: return -1
    if value < 2:
        if return_state_matrix: return q
        return value
    elif value == 2:
        if return_state_matrix: return q
        return 1

    m = []

    alpha = (value-1) // 2
    n = 1

    while alpha >= 1:
        n = int(math.log2(alpha))
        r = q
        for i in range(n):
            r = Multiply(r, r)
        m.append(r)
        alpha -= 2**n
        

    for i in range(1, len(m)):
        m[0] = Multiply(m[0], m[i])
    
    m = Multiply(m[0], m[0])
    
    if (value-1) % 2 != 0:
        m = Multiply(m, q)

    if return_state_matrix: return m
    return m[0][0]


def Handle(value, id, memory, cache):
    if value in cache:
        memory[id] = cache[value]
    else:
        memory[id] = Fibonacci(value, True)
        cache[value] = memory[id]



def ParallelFibonacci(value, num_process=cpu_count()):
    if value < 0:
        return -1
    if value < 2:
        return value
    elif value == 2:
        return 1

    if value < 256:
        return Fibonacci(value)  # type: ignore
    
    unit_fibonacci = Fibonacci(1, True)
    memory = Manager().list([unit_fibonacci for i in range(num_process)])
    cache = Manager().dict()
    list_process = []
    d = value // num_process
    
    for i in range(num_process):
        list_process.append(Process(
            target=Handle,
            args=(d, i, memory, cache)
        ))
    for i in range(num_process):
        list_process[i].start()
    for i in range(num_process):
        list_process[i].join()

    for i in range(1, num_process):
        memory[i] = Multiply(memory[i], unit_fibonacci)
        memory[0] = Multiply(memory[0], memory[i])

    d = value % num_process
    if d > 1:
        memory[0] = Multiply(memory[0], Fibonacci(d))
    if d != 0:
        memory[0] = Multiply(memory[0], unit_fibonacci)

    
    return memory[0][0][0]  # type: ignore

    
if __name__ == "__main__":

    logging.basicConfig(filename="output.log",
                        format='%(asctime)s %(message)s',
                        filemode='w')
    logger = logging.getLogger()
    logger.setLevel(logging.DEBUG)

    start = time.time()
    f = Fibonacci(10)
    end = time.time()
    
    print("Fibonacci O(log(n)) (1000) =", f)
    print("Compute in times:", end-start, "seconds")
    logger.debug("Fibonacci O(log(n))")
    logger.info(f"Fibonacci(1000) -> {f}")
    logger.info(f"Compute in: {end-start} second")

    start = time.time()
    f = ParallelFibonacci(10, 4)
    end = time.time()
    
    print("ParallelFibonacci O(log(n)) (1000) =", f)
    print("Compute in times:", end-start, "seconds")
    logger.debug("Parallel Fibonacci O(log(n))")
    logger.info(f"ParallelFibonacci(1000) -> {f}")
    logger.info(f"Compute in: {end-start} second")
    
    
    
    
    