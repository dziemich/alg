package alg

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TheTimeInWordsTest {

  @Test
  fun returnsFiveOClockOnRoundHour(): Unit {
    val expected = "five o'clock"
    val actual = timeInWords(5, 0)
    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun returnsOneMinutePastFive(): Unit {
    val expected = "one minute past five"
    val actual = timeInWords(5, 1)
    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun returnsTenMinutesPastFive(): Unit {
    val expected = "ten minutes past five"
    val actual = timeInWords(5, 10)
    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun returnsQuarterPastFive(): Unit {
    val expected = "quarter past five"
    val actual = timeInWords(5, 15)
    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun returnsTwentyOnePastFive(): Unit {
    val expected = "twenty one minutes past five"
    val actual = timeInWords(5, 21)
    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun returnsHalfPastFive(): Unit {
    val expected = "half past five"
    val actual = timeInWords(5, 30)
    Assertions.assertEquals(expected, actual)
  }


  @Test
  fun returnsTwentyMinutesToSix(): Unit {
    val expected = "twenty minutes to six"
    val actual = timeInWords(5, 40)
    Assertions.assertEquals(expected, actual)
  }


  @Test
  fun returnsquarterToSix(): Unit {
    val expected = "quarter to six"
    val actual = timeInWords(5, 45)
    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun returnsNineteenMinutesToSix(): Unit {
    val expected = "nineteen minutes to six"
    val actual = timeInWords(5, 41)
    Assertions.assertEquals(expected, actual)
  }


}
