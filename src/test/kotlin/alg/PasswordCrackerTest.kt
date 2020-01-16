package alg

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PasswordCrackerTest {

  @Test
  fun test0(): Unit {
    val passwordCracker = passwordCracker(arrayOf("abcd", "ab", "cd"), "abcd")
    println(passwordCracker)
    Assertions.assertEquals("abcd", passwordCracker)
  }

  @Test
  fun test2(): Unit {
    val passwordCracker = passwordCracker(arrayOf("abx", "ab", "cd"), "abcdxxxx")
    println(passwordCracker)
    Assertions.assertEquals("WRONG PASSWORD", passwordCracker)
  }
  @Test
  fun test3(): Unit {
    val passwordCracker = passwordCracker(arrayOf("because", "can", "do", "must", "we", "what"), "wedowhatwemustbecausewecan")
    println(passwordCracker)
    Assertions.assertEquals("we do what we must because we can", passwordCracker)
  }
}
