package alg

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ClimbingTheLeaderboardTest {

  @Test
  fun tst() {
    val ret = climbingLeaderboard(
      arrayOf(100, 100, 50, 40, 40, 20, 10),
      arrayOf(5, 25, 50, 120)
    )

    print(ret);
    Assertions.assertArrayEquals(ret, arrayOf(6, 4, 2, 1))
  }

  @Test
  fun tst2() {
    val ret = climbingLeaderboard(
      arrayOf(100, 100, 50, 40, 40, 20, 10),
      arrayOf(5, 5, 5, 5)
    )
    print(ret);
    Assertions.assertArrayEquals(ret, arrayOf(6,6,6,6))
  }
}
