## Level 1 – Beginner

### Q1. What is Python and why is it popular for automation?
**Answer:**  
Python is a high-level, interpreted programming language known for its simplicity and readability.  
In automation, its large ecosystem of libraries (like `unittest`, `pytest`, `requests`, `selenium`) and ease of integration make it ideal for rapid scripting and test development.

---

### Q2. How do you calculate the factorial of a number in Python?
**Answer:**
```python
def factorial(n):
    return 1 if n == 0 else n * factorial(n-1)

print(factorial(5))  # Output: 120
```

---

### Q3. Find the length of the last word in a string.
**Answer:**
```python
def last_word_length(s):
    return len(s.strip().split()[-1])

print(last_word_length("Hello world  "))  # Output: 5
```

---

### Q4. Capitalize alternate letters in a name.
**Answer:**
```python
def alternate_caps(name):
    return ''.join(c.upper() if i % 2 == 0 else c.lower() for i, c in enumerate(name))

print(alternate_caps("pasupathi"))  # Output: PaSuPaThI
```

---

### Q5. Count repeated elements in a list.
**Answer:**
```python
data = [1,2,3,1,4,5,2,7,4,1,5,8,9]
freq = {x: data.count(x) for x in set(data) if data.count(x) > 1}
print(freq)  # Output: {1: 3, 2: 2, 4: 2, 5: 2}
```

---

### Q6. What’s the difference between a list and a tuple?
**Answer:**  
- **List** is mutable — elements can be changed.  
- **Tuple** is immutable — elements cannot be changed, but mutable elements inside it can.

```python
t = (10, 20, [30, 40], 70, 80)
t[2].append(50)
print(t)  # Output: (10, 20, [30, 40, 50], 70, 80)
```

---

### Q7. What are comprehensions in Python?
**Answer:**  
A shorthand way to create collections like lists, sets, or dictionaries.

```python
squares = [x*x for x in range(5)]
even_squares = {x: x*x for x in range(10) if x % 2 == 0}
```

---

### Q8. What are context managers?
**Answer:**  
They handle setup and teardown automatically (like closing files).

```python
with open("file.txt", "r") as f:
    data = f.read()
# file is automatically closed
```

Custom context manager:
```python
class Demo:
    def __enter__(self):
        print("Start")
    def __exit__(self, type, value, traceback):
        print("End")
```

---

## Level 2 – Intermediate

### Q1. Sort a list of tuples by quantity.
```python
items = [("cherry",5), ("orange",19), ("banana",32), ("apple",10)]
sorted_items = sorted(items, key=lambda x: x[1])
print(sorted_items)
```

---

### Q2. Explain *args and **kwargs.
**Answer:**  
- `*args` passes variable number of positional arguments.  
- `**kwargs` passes variable number of keyword arguments.

```python
def demo(*args, **kwargs):
    print(args)
    print(kwargs)

demo(1, 2, 3, name="test")
```

---

### Q3. Explain decorators with example.
**Answer:**  
A decorator modifies a function’s behavior without changing its code.

```python
def log(func):
    def wrapper(*args, **kwargs):
        print(f"Running {func.__name__}")
        return func(*args, **kwargs)
    return wrapper

@log
def test_case():
    print("Executing test")
```

---

### Q4. What is GIL and how does it affect multithreading?
**Answer:**  
GIL (Global Interpreter Lock) allows only one thread to execute Python bytecode at a time.  
It limits CPU-bound parallelism but not I/O-bound tasks.  

To achieve true parallelism for CPU-bound tasks, use:
- `multiprocessing` module  
- `concurrent.futures.ProcessPoolExecutor`

---

### Q5. Explain OOP principles briefly.
**Answer:**
- **Encapsulation** – restrict access using classes/objects.  
- **Inheritance** – derive classes from others.  
- **Polymorphism** – same interface, different behavior.  
- **Abstraction** – hide complex details.

---

### Q6. What are metaclasses in Python?
**Answer:**  
A metaclass defines how classes behave. It’s like a “class of a class.” Used for logging, enforcing rules, or auto-registering subclasses.

```python
class Meta(type):
    def __new__(cls, name, bases, attrs):
        print(f"Creating class {name}")
        return super().__new__(cls, name, bases, attrs)

class Test(metaclass=Meta):
    pass
```

---

### Q7. Explain descriptors and __get__, __set__, __delete__.
**Answer:**  
Descriptors control attribute access in a class.

```python
class Descriptor:
    def __get__(self, obj, objtype=None):
        return obj._value
    def __set__(self, obj, value):
        obj._value = value

class Example:
    value = Descriptor()
```

---

### Q8. Purpose of __slots__ in Python classes.
**Answer:**  
Restricts dynamic attribute creation, saving memory.

```python
class Point:
    __slots__ = ('x', 'y')
```

---

### Q9. Difference between async def and def.
**Answer:**  
`async def` defines a coroutine, executed asynchronously with `await`.  

```python
import asyncio

async def fetch_data():
    await asyncio.sleep(1)
    return "done"
```

---

### Q10. Modify class behavior without changing source code.
**Answer:**  
Use **monkey patching** or **decorators**.

```python
class A:
    def greet(self): return "Hi"

def new_greet(): return "Hello"

A.greet = new_greet
```

---

## Level 3 – Expert

### Q1. Explain Python’s garbage collection and generational GC.
**Answer:**  
Python uses reference counting + cyclic garbage collector.  
Objects are grouped into generations; newer objects are collected more frequently.

---

### Q2. Explain MRO (Method Resolution Order).
**Answer:**  
Defines the order in which base classes are searched for a method.

```python
class A: pass
class B(A): pass
class C(B, A): pass
print(C.mro())
```

---

### Q3. Explain how `@property` works.
**Answer:**
It allows methods to be accessed like attributes.

```python
class User:
    def __init__(self, name):
        self._name = name

    @property
    def name(self):
        return self._name.title()
```

---

### Q4. What are generators and why are they useful?
**Answer:**  
Generators yield items one at a time using `yield`, saving memory.

```python
def gen():
    for i in range(3):
        yield i
```

---

### Q5. Explain how you would handle exceptions gracefully.
**Answer:**
Use `try/except/finally` and raise specific exceptions.

```python
try:
    1 / 0
except ZeroDivisionError as e:
    print("Cannot divide by zero:", e)
finally:
    print("Cleanup")
```

---

### Q6. Explain shallow vs deep copy.
**Answer:**
- **Shallow copy:** creates new object but references same inner objects.  
- **Deep copy:** copies all nested objects.

```python
import copy
a = [[1,2], [3,4]]
b = copy.deepcopy(a)
```

---

### Q7. Explain how Python’s memory management works.
**Answer:**
Python uses reference counting and garbage collection. `sys.getrefcount(obj)` returns the count.  
Memory for small integers and strings is cached for reuse.

---

### Q8. What are data classes?
**Answer:**
Simplify class creation for storing data.

```python
from dataclasses import dataclass

@dataclass
class TestResult:
    name: str
    status: str
```

---

### Q9. Explain import mechanisms and circular import issues.
**Answer:**
When two modules import each other, circular dependency occurs.  
Solution: restructure code, import inside functions, or use lazy imports.

---

### Q10. Explain how you would optimize Python test code.
**Answer:**
- Avoid repeated setup (use fixtures or shared objects).  
- Use caching (`functools.lru_cache`).  
- Minimize global variables.  
- Use multiprocessing for parallel execution.
