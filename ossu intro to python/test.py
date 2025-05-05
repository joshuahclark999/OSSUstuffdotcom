import time

def convert_to_km(m):
    return m *1.609

t0 = time.perf_counter()
convert_to_km(100000)
dt = time.perf_counter() - t0

# print("t=",dt,"s")

L_N = [1]
for i in range(7):
    L_N.append(L_N[-1]*10)

for N in L_N:
    t = time.perf_counter()
    km = convert_to_km(N)
    dt = time.perf_counter() - t
    print(f'convert_to_km({N}) took {dt:.2e} seconds ({1/dt}/sec)')