package alg

import java.math.BigInteger

fun extraLongFactorials(n: Int): Unit {
  val r = fact(n)
  print(r)
}

fun fact(n: Int): BigInteger {
  return if (n == 0) BigInteger.valueOf(1.toLong()) else BigInteger.valueOf(n.toLong()).times(fact(n - 1))
}
