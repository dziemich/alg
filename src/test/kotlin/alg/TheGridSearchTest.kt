package alg

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TheGridSearchTest {

  @Test
  fun test() {
    val res = gridSearch(
      arrayOf(
        "7283455864",
        "6731158619",
        "8988242643",
        "3830589324",
        "2229505813",
        "5633845374",
        "6473530293",
        "7053106601",
        "0834282956",
        "4607924137"
      ),
      arrayOf(
        "9505",
        "3845",
        "3530"
      )
    )

    Assertions.assertEquals("YES", res)
  }

  @Test
  fun test2() {
    val res = gridSearch(arrayOf("123", "256", "378", "465", "534", "644"), arrayOf("65", "37"))

    Assertions.assertEquals("NO", res)
  }

  @Test
  fun test3() {
    val res = gridSearch(
      arrayOf(
        "123456",
        "567890",
        "234567",
        "194729"
      ),
      arrayOf(
        "2345",
        "6789",
        "3456",
        "9472"
      )
    )

    Assertions.assertEquals("YES", res)
  }

  @Test
  fun test4() {
    val res = gridSearch(
      arrayOf(
        "999999",
        "121211"
      ),
      arrayOf(
        "99",
        "11"
      )
    )

    Assertions.assertEquals("YES", res)
  }
  @Test
  fun test5() {
    val res = gridSearch(
      arrayOf(
        "111111111111111",
        "111111111111111",
        "111111111111111",
        "111111011111111",
        "111111111111111",
        "111111111111111",
        "101010101010101"
      ),
      arrayOf(
        "11111",
        "11111",
        "11111",
        "11110"

      )
    )

    Assertions.assertEquals("YES", res)
  }

}
