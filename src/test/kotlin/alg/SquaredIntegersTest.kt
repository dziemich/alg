package alg

import alg.findSmallestNumberOfSquaredIntegers
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SquaredIntegersTest {
  @Test
  fun verifiesSquares13EqualsTo2(): Unit {
    Assertions.assertEquals(2, findSmallestNumberOfSquaredIntegers(13))
  }
  @Test
  fun verifiesSquares27EqualsTo3(): Unit {
    Assertions.assertEquals(3, findSmallestNumberOfSquaredIntegers(27))
  }
  @Test
  fun verifiesSquares15EqualsTo4(): Unit {
    Assertions.assertEquals(4, findSmallestNumberOfSquaredIntegers(15))
  }
  @Test
  fun verifiesSquares324EqualsTo1(): Unit {
    Assertions.assertEquals(1, findSmallestNumberOfSquaredIntegers(324))
  }
  @Test
  fun verifiesSquares324EqualsToX(): Unit {
    Assertions.assertEquals(3, findSmallestNumberOfSquaredIntegers(9993))
  }
}
