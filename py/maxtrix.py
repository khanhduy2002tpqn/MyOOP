import numpy as np
from numba import njit, prange
import time

@njit(parallel=True)
def mat_mult(A, B):
    assert A.shape[1] == B.shape[0]
    res = np.zeros((A.shape[0], B.shape[1]), )
    for i in prange(A.shape[0]):
        for k in range(A.shape[1]):
            for j in range(B.shape[1]):
                res[i,j] += A[i,k] * B[k,j]
    return res

m = 20000
A = np.random.randint(1, 50, size = (m, m))
B = np.random.randint(1, 50, size = (m, m))

start = time.perf_counter()
res = mat_mult(A, B)
end = time.perf_counter()
print(res)
print(f"Time taken to complete mult() {m}x{m}: {round(end - start, 5)} seconds(s)")