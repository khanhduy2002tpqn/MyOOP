import numpy as np
import time
from multiprocessing.pool import ThreadPool
from multiprocessing import Process, RawArray, Queue, cpu_count
from ctypes import c_float


class Pointer:
    def __init__(self, area):
        self.__area = area
        self.__x = 0
        self.__y = 0
    
    @property
    def X(self):
        return self.__x
    
    @property
    def Y(self):
        return self.__y
    
    def Next(self):
        self.__y += 1
        if self.__y == self.__area[1]:
            self.__y = 0
            self.__x += 1

            if self.__x == self.__area[0]:
                self.__x = -1


def Multiply(a_b):
    return a_b[0]*a_b[1]


def SumElement(element):
    return element[0]+element[1]


def ParallelSumOfTensor(tensor):

    tensor = np.array(tensor, dtype=np.float32)

    with ThreadPool(num_cpu) as p:
        while(tensor.shape[0]>1):
            tensor = tensor.reshape(int(tensor.shape[0]/2), 2)
            tensor = p.map_async(SumElement, tensor)
            tensor = np.array(tensor.get(), dtype=np.float32)

            if tensor.shape[0]%2 and tensor.shape[0]>1:
                tensor = np.append(tensor, [0,])
        
    return tensor[0]


def HandleMultiplyMatrix(row, column, index_row, index_column, queue):
    print(f" ~ Computing C[{index_row}][{index_column}]...", "\t")

    tensor = np.concatenate((row, column)).reshape(2, shape[1]).T
    result = {"i": index_row, "j": index_column}

    with ThreadPool(num_cpu) as p:
        tensor = p.map_async(Multiply, tensor)
        result["c"] = ParallelSumOfTensor(tensor.get())

    queue.put(result)


def ParallelMultiplyMatrix(a, b, c):

    n_a = np.frombuffer(a, dtype=np.float32).reshape(shape[0], shape[1])
    n_b = np.frombuffer(b, dtype=np.float32).reshape(shape[0], shape[1]).T
    n_c = np.frombuffer(c, dtype=np.float32).reshape(shape[0], shape[1])

    num_process = num_cpu
    
    pointer = Pointer(n_c.shape)    
    queue = Queue()

    while pointer.X != -1:
        
        process_list = []
        for p in range(num_process):
            process_list.append(Process(
                target=HandleMultiplyMatrix,
                args=(n_a[pointer.X], n_b[pointer.Y], pointer.X, pointer.Y, queue)
            ))
            pointer.Next()
            if pointer.X == -1:
                break
        
        num_process = len(process_list)
        for p in range(num_process):
            process_list[p].start()
        for p in range(num_process):
            process_list[p].join()
        

        for p in range(num_process):
            result = queue.get()
            n_c[result["i"]][result["j"]] = result["c"]
        
        print(str("\033[A") * (num_process+1))
        

    return n_c

if __name__ == "__main__":
    
    shape = (100, 100)
    num_cpu = cpu_count()

    print("Random matrix A with shape:", shape)
    a = RawArray(c_float, shape[0]*shape[1])
    n_a = np.frombuffer(a, dtype=np.float32).reshape(shape[0], shape[1])  # type: ignore
    np.copyto(n_a, np.random.rand(shape[0], shape[1]).astype(np.float32))

    print("Random matrix B with shape:", shape)
    b = RawArray(c_float, shape[0]*shape[1])
    n_b = np.frombuffer(b, dtype=np.float32).reshape(shape[0], shape[1])  # type: ignore
    np.copyto(n_b, np.random.rand(shape[0], shape[1]).astype(np.float32))

    c = RawArray(c_float, shape[0]*shape[1])

    print("Compte matrix C = A x B:")
    
    start_time = time.time()
    n_c = ParallelMultiplyMatrix(a, b, c)
    end_time = time.time()

    print("\nResult matrix C\n")
    print(n_c)
    print("\n Compute C = A x B in: ", end_time-start_time, "seconds.")

