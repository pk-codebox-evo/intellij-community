# Stubs for Crypto.Util.number (Python 3.5)
#
# NOTE: This dynamically typed stub was automatically generated by stubgen.

from typing import Any, Optional
from warnings import warn as _warn

__revision__ = ...  # type: str
bignum = ...  # type: Any

def size(N): ...
def getRandomNumber(N, randfunc: Optional[Any] = ...): ...
def getRandomInteger(N, randfunc: Optional[Any] = ...): ...
def getRandomRange(a, b, randfunc: Optional[Any] = ...): ...
def getRandomNBitInteger(N, randfunc: Optional[Any] = ...): ...
def GCD(x, y): ...
def inverse(u, v): ...
def getPrime(N, randfunc: Optional[Any] = ...): ...
def getStrongPrime(N, e: int = ..., false_positive_prob: float = ..., randfunc: Optional[Any] = ...): ...
def isPrime(N, false_positive_prob: float = ..., randfunc: Optional[Any] = ...): ...
def long_to_bytes(n, blocksize: int = ...): ...
def bytes_to_long(s): ...
def long2str(n, blocksize: int = ...): ...
def str2long(s): ...

sieve_base = ...  # type: Any
