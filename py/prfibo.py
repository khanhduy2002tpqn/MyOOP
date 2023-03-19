import multiprocessing as mp

# save all Fibonacci Sequence
fibNumbers = []


def fibonacciCalc(num):
    """ Calculate for find the Fibonacci code for the number asigned """
    if num <= 2:
        fibNumbers.append(1)
        return 1

    else:
        # calculate the fibonacci code according to a index
        fibValue = fibNumbers[num-2] + fibNumbers[num-3]
        fibNumbers.append(fibValue)
        return fibValue


def factorization(fib):
    """ Numeric factorization for a fibonacci number """
    print(f"initializing factorization for {fib}")

    divisor = 2
    values = []

    # save unfactorizable values
    if fib <= 5:
        values.append(str(fib))

    else:
        while fib != 1:

            # finding divisors
            if fib % divisor == 0:
                values.append(str(divisor))
                fib = fib/divisor

            else:
                divisor += 1
    return values



def app(LIMIT):
    """ Principal function to alculate fibonacci series from 1 to LIMIT """
    print('*************** Fibonacci Sequence ***************')

    # list with numbers to evalue
    valuesRange = list(range(LIMIT+1))[1:]

    # Init multiprocessing.Pool() for calculate fibonacci series
    with mp.Pool(mp.cpu_count()) as pool:
        # calculate the fibonacci for the current value i
        savesFib = pool.map(fibonacciCalc, [i for i in valuesRange])

    print("Fibonacci values has finished its calculation")
    print(savesFib)

    


if __name__ == "__main__":
    """ Main execution"""

    # max numer to calculate fibonacci series
    LIMIT = 1000

    # Calculate fibonacci series from 1 to LIMIT
    app(LIMIT)