import alg.superDigit
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SuperDigitTest {

  @Test
  fun test1(): Unit {
    val res = superDigit("123", 1)
    Assertions.assertEquals(6, res);
  }
}
